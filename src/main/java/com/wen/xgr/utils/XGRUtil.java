package com.wen.xgr.utils;

import com.alibaba.fastjson.JSONObject;
import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.inter.IHandleAttr;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class XGRUtil<T> {

    private Class<T> resolverClazz;

    private String headLabel;
    private Class<?> headAttr;

    private Document doc;

    private JSONObject userData;

    private T obj;
    private List<Object[]> fieldList = new ArrayList<>();

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
            if (field.isAnnotationPresent(XmlField.class)) {
                fieldList.add(new Object[]{field, field.getAnnotation(XmlField.class)});
            }
        }
        XmlHead xmlHead = this.resolverClazz.getAnnotation(XmlHead.class);
        this.headLabel = xmlHead.value();
        this.headAttr = xmlHead.attr();
    }


    public String convertXML(T obj) throws Exception {
        return convertXML(obj, false);
    }

    private String convertXML(T obj, boolean flag) throws Exception {
        this.obj = obj;
        Element element = doc.addElement(this.headLabel);
        getRoot(element, obj, flag);
        return xmlPrint(doc);
    }

    private Element getRoot(Element element, T obj, boolean flag) throws Exception {
        handlerAttr(element, this.headAttr);
        for (Object[] objects : this.fieldList) {
            Field field = (Field) objects[0];
            XmlField xmlField = (XmlField) objects[1];
            field.setAccessible(true);
            Object val = field.get(obj);
            generateRootNodeXmlDoc(element, val, xmlField);
        }
        return element;
    }

    private Element generateRootNodeXmlDoc(Element ele, Object val, XmlField xmlField) throws Exception {
        Element element = ele.addElement(xmlField.value());
        handlerAttr(element, xmlField.attr());
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
        for (Object v : val) {
            handleType(listElement, v, xmlField);
        }
    }
    private void processSetType(Element listElement, Set val, XmlField xmlField) throws Exception {
        for (Object v : val) {
            handleType(listElement, v, xmlField);
        }
    }

    private void processOtherType(Element element, Object val, XmlField xmlField) throws Exception {
        if (val == null) {
            return;
        }
        XGRUtil subXGR = new XGRUtil(val.getClass());
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
        if (xmlField != null) {
            handlerAttr(ele, xmlField.attr());
        }
    }

    private void handlerAttr(Element ele, Class<?> attrHandler) {
        if (attrHandler == null) {
            return;
        }
        Map<String, String> attrs = new HashMap<>();
        try {
            IHandleAttr iHandleAttr = (IHandleAttr) attrHandler.newInstance();
            attrs = iHandleAttr.handleAttr(ele, this.obj, this.userData);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        for (String key : attrs.keySet()) {
            String value = attrs.get(key);
            ele.addAttribute(key, value);
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
}
