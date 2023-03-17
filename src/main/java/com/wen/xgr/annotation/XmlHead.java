package com.wen.xgr.annotation;


import com.wen.xgr.inter.DefaultHandleAttr;
import com.wen.xgr.inter.IHandleAttr;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface XmlHead {

    String value();

    Class<?> attr() default DefaultHandleAttr.class;

    boolean isToXml() default true;

    boolean isToObj() default true;
}
