package com.wen.xgr.utils;

import cn.hutool.core.lang.ParameterizedTypeImpl;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;
import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.domian.User;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;

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

    public static Class<?> getClassTypeForName(Object entity, String fileName) throws Exception {
        Type type = entity.getClass().getDeclaredField(fileName).getGenericType();
        return getClassTypeByCollectType(type);
    }

    /**
     *  通过反射set column的值
     */
    public static boolean reflectSetObjectValue(String fieldName, Object value ,Object obj){
        // 通过反射查询 set fieldName的value
        Method[] methods = obj.getClass().getMethods();
        Method curMethod = null;
        for (Method method : methods) {
            String s = fieldName.substring(0, 1).toUpperCase();
            s = s + fieldName.substring(1);
            if (("set" + s).equals(method.getName())) {
                curMethod = method;
                break;
            }
        }
        if (curMethod != null) {
            try {
                if (value == null || StringUtils.isEmpty(String.valueOf(value))) {
                    return true;
                }
                int parameterCount = curMethod.getParameterCount();
                if (parameterCount == 1) {
                    Class<?> parameterType = curMethod.getParameterTypes()[0];
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
                    curMethod.invoke(obj, value);
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
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
