package com.wen.xgr.utils;

import cn.hutool.core.lang.ParameterizedTypeImpl;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;
import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.domian.User;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReflectUtil {

    //
    public static Class<?> getClassTypeByCollectType(Type genericType) throws Exception {
        Class clazz = null;
        if(genericType instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) genericType;
            //得到泛型里的class类型对象
            if (pt.getActualTypeArguments()[0] instanceof sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl) {

            }else {
                clazz = (Class<?>)pt.getActualTypeArguments()[0];
            }
        }
        return clazz;
    }


    /**
     * 循环向上转型, 获
     * @param object : 子类对象
     * @param fieldName : 父类中
     * @return 父类中
     * */
    public static Field getDeclaredField(Object object, String fieldName){
        Field field = null;
        Class<?> clazz = object.getClass();
        for(;clazz != Object.class; clazz = clazz.getSuperclass()){
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (NoSuchFieldException e) {
                //不需要处理
                //不断向父类查询是否有某个字段
            }
        }
        return null;
    }

    public static List<Field> getDeclaredFields(Class clazz){
        List<Field> fields = new ArrayList<>();
        for(;clazz != Object.class; clazz = clazz.getSuperclass()){
            fields.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
        }
        return fields;
    }


    public static Class<?> getClassTypeForName(Object entity, String fileName) throws Exception {
        Type type = ReflectUtil.getDeclaredField(entity, fileName).getGenericType();
        return getClassTypeByCollectType(type);
    }

    /**
     *  通过反射set column的值
     */
    public static boolean reflectSetObjectValue(String fieldName, Object value ,Object obj){
        // 通过反射查询 set fieldName的value
        Field field = getDeclaredField(obj, fieldName);
        if (field != null) {
            try {
                if (value == null) {
                    return true;
                }
                Class<?> parameterType = field.getType();
                if (parameterType == Long.class) {
                    value = Long.valueOf(String.valueOf(value));
                }
                if (parameterType == String.class) {
                    value = String.valueOf(value);
                }
                if (parameterType == Integer.class) {
                    value = Integer.valueOf(String.valueOf(value));
                }
                if (parameterType == Double.class) {
                    value = Double.valueOf(String.valueOf(value));
                }
                if (parameterType == BigDecimal.class) {
                    value = BigDecimal.valueOf(Double.parseDouble(String.valueOf(value)));
                }
                if (parameterType == Date.class && isDate(value)) {
                    value = new Date(Long.parseLong(String.valueOf(value)));
                }
                //控制Java对其的检查
                field.setAccessible(true);
                //将object中field所代表的的值设置为value
                try {
                    field.set(obj, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static Object reflectGetObjectValue(String fieldName ,Object obj){
        // 通过反射查询 set fieldName的value
        Method[] methods = obj.getClass().getMethods();
        Method curMethod = null;
        for (Method method : methods) {
            String s = fieldName.substring(0, 1).toUpperCase();
            s = s + fieldName.substring(1);
            if (("get" + s).equals(method.getName())) {
                curMethod = method;
                break;
            }
        }
        if (curMethod != null) {
            try {
                return curMethod.invoke(obj);
            } catch (Exception e) {
                return false;
            }
        }
        return null;
    }

    public static boolean isDate(Object timestamp) {
        try {
            if (("" + timestamp).length() != 13) {
                return false;
            }
            if (timestamp instanceof Long) {
                new Date(Long.parseLong(String.valueOf(timestamp)));
                return true;
            }
        }catch (Exception e) {
            return false;
        }

        return false;
    }


}
