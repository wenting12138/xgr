package com.wen.xgr.utils;

import com.alibaba.fastjson.JSONObject;
import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.exception.XGRException;
import com.wen.xgr.inter.IHandleAttr;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XGRUtil<T> {

    public static final String headerAttrFieldName = "headerAttrs";
    public static final String fieldsAttrFieldName = "fieldsAttrs";

    private Class<T> resolverClazz;

    private String headLabel;
    private boolean headIsToXML;
    private Class<?> headAttr;

    private Document doc;

    private JSONObject userData;

    private T obj;
    private List<Object[]> convertXmlfieldList = new ArrayList<>();

    private List<Object[]> convertObjFieldList = new ArrayList<>();

    public XGRUtil(Class<T> resolverClazz) {
        this.resolverClazz = resolverClazz;
        // 初始化文档
        this.doc = DocumentHelper.createDocument();
        // 解析注解
        init();
    }

    public void setUserData(JSONObject userData){
        this.userData = userData;
    }

    private void init(){
        // 解析注解
        for (Field field : this.resolverClazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlField.class) && field.getAnnotation(XmlField.class).isToXml()) {
                convertXmlfieldList.add(new Object[]{field, field.getAnnotation(XmlField.class)});
            }
            if (field.isAnnotationPresent(XmlField.class) && field.getAnnotation(XmlField.class).isToObj()) {
                convertObjFieldList.add(new Object[]{field, field.getAnnotation(XmlField.class)});
            }
        }
        XmlHead xmlHead = this.resolverClazz.getAnnotation(XmlHead.class);
        this.headIsToXML = xmlHead.isToXml();
        this.headLabel = xmlHead.value();
        this.headAttr = xmlHead.attr();
    }


    public String convertXML(T obj) throws Exception {
        return convertXML(obj, false);
    }

    private String convertXML(T obj, boolean flag) throws Exception {
        this.obj = obj;
        if (headIsToXML) {
            Element element = doc.addElement(this.headLabel);
            getRoot(element, obj, flag);
        }
        return xmlPrint(doc);
    }

    private Element getRoot(Element element, T obj, boolean flag) throws Exception {
        handlerAttr(element, headerAttrFieldName, obj);
        for (Object[] objects : this.convertXmlfieldList) {
            Field field = (Field) objects[0];
            XmlField xmlField = (XmlField) objects[1];
            field.setAccessible(true);
            Object val = field.get(obj);
            generateRootNodeXmlDoc(element, val, xmlField, obj);
        }
        return element;
    }

    private Element generateRootNodeXmlDoc(Element ele, Object val, XmlField xmlField, T obj) throws Exception {
        Element element = ele.addElement(xmlField.value());
        handlerAttr(element, fieldsAttrFieldName, obj);
        handleType(element, val, xmlField);
        return element;
    }

    private void handleType(Element element, Object val, XmlField xmlField) throws Exception {
        // 普通类型
        if (judgeNormalType(val)) {
            processNormalType(element, val, xmlField);
            // map set list
        }else if (judgeMapSetListType(val)) {
            processCollectType(element, val, xmlField);
        }else {
            // 其他对象
            processOtherType(element, val, xmlField);
        }
    }

    private void processCollectType(Element element, Object val, XmlField xmlField) throws Exception {
        if (val instanceof Map) {
            Map map = (Map) val;
            processMapType(element, map, xmlField);
        }
        if (val instanceof List) {
            List list = (List) val;
            processListType(element, list, xmlField);
        }
        if (val instanceof Set) {
            Set set = (Set) val;
            processSetType(element, set, xmlField);
        }
    }

    private void processMapType(Element mapElement, Map val, XmlField xmlField) throws Exception {
        for (Object key : val.keySet()) {
            Element element = mapElement.addElement((String) key);
            handleType(element, val.get(key), xmlField);
        }
    }

    private void processListType(Element listElement, List val, XmlField xmlField) throws Exception {
        boolean flag = false;
        for (Object v : val) {
            if (judgeNormalType(v)) {
                flag = true;
                break;
            } else if (judgeMapSetListType(v)) {
                handleType(listElement, v, xmlField);
            } else {
                XmlHead head = v.getClass().getAnnotation(XmlHead.class);
                if (head.isToXml()) {
                    Element element = listElement.addElement(head.value());
                    handleType(element, v, xmlField);
                }
            }
        }
        if (flag) {
            handleType(listElement, StringUtils.join(val, ","), xmlField);
        }
    }
    private void processSetType(Element listElement, Set val, XmlField xmlField) throws Exception {
        for (Object v : val) {
            XmlHead head = v.getClass().getAnnotation(XmlHead.class);
            if (head.isToXml()) {
                Element element = listElement.addElement(head.value());
                handleType(element, v, xmlField);
            }
        }
    }

    private void processOtherType(Element element, Object val, XmlField xmlField) throws Exception {
        if (val == null) {
            return;
        }
        XGRUtil subXGR = new XGRUtil(val.getClass());
        subXGR.setUserData(this.userData);
        subXGR.getRoot(element, val, true);
    }

    // 判断基本类型
    private boolean judgeNormalType(Object val){
        return val instanceof Integer
                || val instanceof String
                || val instanceof Double
                || val instanceof Float
                || val instanceof Short
                || val instanceof Long
                || val instanceof Date;
    }

    // 判断 list map  set 的类型
    private boolean judgeMapSetListType(Object val){
        return val instanceof List
                || val instanceof Set
                || val instanceof Map;
    }

    private void processNormalType(Element ele, Object val, XmlField xmlField) throws IllegalAccessException {
        if (val == null) {
            return;
        }
        // 处理文本内容
        if (val instanceof Date) {
            Date date = (Date) val;
            ele.addText(dateFormat(date, xmlField.dateFormat()));
        } else {
            ele.addText(String.valueOf(val));
        }
        // 处理属性
//        if (xmlField != null) {
//            handlerAttr(ele, xmlField.attr());
//        }
    }

    private void handlerAttr(Element ele, String attrFieldName, T obj) {
        Map<String, String> attrs = new HashMap<>();
        if (headerAttrFieldName.equals(attrFieldName)) {
            Object o = ReflectUtil.reflectGetObjectValue(attrFieldName, obj);
            if (o != null) {
                attrs = (Map<String, String>) o;
            }
        }
        if (fieldsAttrFieldName.equals(attrFieldName)) {
            Object o = ReflectUtil.reflectGetObjectValue(attrFieldName, obj);
            if (o != null) {
                Map<String, Map<String, String>> attrsMap = (Map<String, Map<String, String>>) o;
                attrs = attrsMap.get(ele.getName());
            }
        }
        if (attrs != null) {
            for (String key : attrs.keySet()) {
                String value = attrs.get(key);
                ele.addAttribute(key, value);
            }
        }
    }

    private String xmlPrint(Document doc) {
        StringWriter sw = new StringWriter();
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding(StandardCharsets.UTF_8.name());
        XMLWriter xmlWriter = new XMLWriter(sw, format);
        try {
            xmlWriter.write(doc);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    private String dateFormat(Date time, String pattern){
        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(time);
    }

    private Date dateParse(String time, String pattern) throws Exception {
        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(time);
    }

    /**
     * 验证 xml格式是否正确
     * @param xmlStr xmlStr
     * @throws Exception Exception
     */
    public boolean isXmlDocument(String xmlStr) {
        try {
            DocumentHelper.parseText(xmlStr);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public T convertObj(String xml) throws Exception {
        verifyXML(xml);
        Document document = DocumentHelper.parseText(xml);
        Element rootElement = document.getRootElement();
        T entity = resolverClazz.newInstance();
        getObj(entity, rootElement);
        return entity;
    }

    private void getObj(Object entity, Element rootElement) {
        fillAttrs(entity, headerAttrFieldName, rootElement);
        fillEntity(entity, rootElement);
    }

    private void fillAttrs(Object entity, String attrFieldName, Element rootElement) {
        if (headerAttrFieldName.equals(attrFieldName)) {
            Map<String, String> attrs = new HashMap<>();
            List<Attribute> attributes = rootElement.attributes();
            if (attributes.size() > 0) {
                for (Attribute attribute : attributes) {
                    attrs.put(attribute.getName(), attribute.getValue());
                }
            }
            ReflectUtil.reflectSetObjectValue(attrFieldName, attrs, entity);
        }
        if (fieldsAttrFieldName.equals(attrFieldName)) {
            Map<String, Map<String, String>> mapAttrs = new HashMap<>();
            Object o = ReflectUtil.reflectGetObjectValue(attrFieldName, entity);
            if (o != null) {
                mapAttrs = (Map<String, Map<String, String>>) o;
            }
            Map<String, String> map = mapAttrs.get(rootElement.getName());
            if (map == null) {
                map = new HashMap<>();
            }
            List<Attribute> attributes = rootElement.attributes();
            if (attributes.size() > 0) {
                for (Attribute attribute : attributes) {
                    map.put(attribute.getName(), attribute.getValue());
                }
                mapAttrs.put(rootElement.getName(), map);
            }
            ReflectUtil.reflectSetObjectValue(attrFieldName, mapAttrs, entity);
        }
    }

    private void fillEntity(Object entity, Element rootElement) {
        for (Object[] objects : this.convertObjFieldList) {
            Field field = (Field) objects[0];
            XmlField xmlField = (XmlField) objects[1];
            fillField(field.getName(), field.getType(), xmlField.value(), entity, rootElement, xmlField);
        }
    }

    private void fillField(String fieldName, Class<?> type, String id, Object entity, Element rootElement, XmlField xmlField) {
        Element element = rootElement.element(id);
        if (element != null) {
            fillAttrs(entity, fieldsAttrFieldName, element);
            if (determineNormalFiled(type)) {
                // 基本数据类型处理
                fillNormalField(fieldName, type, id, entity, element, xmlField);
            }else if (determineCollectFiled(type)) {
                // 集合数据类型处理
                fillCollectField(fieldName, id, entity, element);
            }else {
                // 对象数据类型处理
                fillObjectField(fieldName, id, entity, element);
            }
        }
    }

    private void fillCollectField(String fieldName, String eleId, Object entity, Element element) {
        try {
            Class<?> type = entity.getClass().getDeclaredField(fieldName).getType();
            if (type == List.class) {
                fillListField(fieldName, entity, element);
            } else if (type == Map.class){
                fillMapField(fieldName, entity, element);
            }else if (type == Set.class) {
                fillSetField(fieldName, entity, element);
            }
        } catch (Exception e) {
            System.out.println("获取失败");
        }
    }

    private void fillSetField(String fieldName, Object entity, Element element) {
        if (element.elements().size() > 0) {
            try {
                Set set = new HashSet();
                Iterator iterator = element.elements().iterator();
                // 由list类型对象获取元素的类型
                Class<?> clazz = ReflectUtil.getClassTypeForName(entity, fieldName);
                Object subEntity = clazz.newInstance();
                if (iterator.hasNext()) {
                    Element subEle = (Element) iterator.next();
                    XGRUtil subUtil = new XGRUtil(clazz);
                    subUtil.getObj(subEntity, subEle);
                    set.add(subEntity);
                }
                ReflectUtil.reflectSetObjectValue(fieldName, set, entity);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("反射获取对象失败" + e);
            }
        }
    }

    private void fillMapField(String fieldName, Object entity, Element element) {
        if (element.elements().size() > 0) {
            try {
                Map map = new HashMap();
                Iterator iterator = element.elements().iterator();
                if (iterator.hasNext()) {
                    Element subEle = (Element) iterator.next();
                    String name = subEle.getName();
                    String textTrim = subEle.getTextTrim();
                    map.put(name, textTrim);
                }
                ReflectUtil.reflectSetObjectValue(fieldName, map, entity);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("反射获取对象失败" + e);
            }
        }
    }

    private void fillListField(String fieldName, Object entity, Element element) {
        try {
            List list = new ArrayList();
            // 由list类型对象获取元素的类型  todo 不支持 List<Map<String,String>>
            Class<?> clazz = ReflectUtil.getClassTypeForName(entity, fieldName);
            if (clazz == null) {
                // map
                System.out.println(element.elements().size());
                for (Object o : element.elements()) {
                    Element subEle = (Element) o;
                    Map map = new HashMap();
                    String name = subEle.getName();
                    String text = subEle.getText();
                    map.put(name, text);
                    list.add(map);
                }
            }else {
                if (determineNormalFiled(clazz)) {
                    if (StringUtils.isNotEmpty(element.getText())) {
                        list = Arrays.asList(element.getText().split(","));
                    }
                }else {
                    System.out.println(element.elements().size());
                    Iterator iterator = element.elements().iterator();
                    while (iterator.hasNext()) {
                        Object subEntity = clazz.newInstance();
                        Element subEle = (Element) iterator.next();
                        XGRUtil subUtil = new XGRUtil(clazz);
                        subUtil.getObj(subEntity, subEle);
                        list.add(subEntity);
                    }
                }
            }
            ReflectUtil.reflectSetObjectValue(fieldName, list, entity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("反射获取对象失败" + e);
        }
    }

    private void fillObjectField(String fieldName, String eleId, Object entity, Element element) {
        try {
            Class<?> type = entity.getClass().getDeclaredField(fieldName).getType();
            Object subEntity = type.newInstance();
            XGRUtil subUtil = new XGRUtil(type);
            subUtil.setUserData(this.userData);
            subUtil.getObj(subEntity, element);
            ReflectUtil.reflectSetObjectValue(fieldName, subEntity, entity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取field失败 + " + e);
        }
    }

    private boolean determineCollectFiled(Class fieldType) {
        return fieldType == List.class
                || fieldType == Set.class
                || fieldType == Map.class;
    }

    private void fillNormalField(String fieldName, Class<?> type, String eleId, Object entity, Element element, XmlField xmlField) {
        try {
            if (StringUtils.isNotEmpty(element.getText())) {
                Object content = element.getTextTrim();
                if (type == Date.class) {
                    content = dateParse(String.valueOf(content), xmlField.dateFormat());
                }
                ReflectUtil.reflectSetObjectValue(fieldName, content, entity);
            }
        } catch (Exception e) {
            System.out.println("fill field error: " + e);
        }
    }



    // 判断属性的类型
    private boolean determineNormalFiled(Class fieldType){
        return fieldType == Date.class
                || fieldType == Byte.class
                || fieldType == Short.class
                || fieldType == Integer.class
                || fieldType == Long.class
                || fieldType == Double.class
                || fieldType == Float.class
                || fieldType == String.class;
    }

    private boolean verifyXML(String xml) {
        if (!isXmlDocument(xml)) {
            throw new XGRException("xml is valid");
        }
        return false;
    }
}
