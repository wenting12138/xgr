package com.wen.xgr.annotation;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface XmlHead {

    String value();

    boolean isToXml() default true;

    boolean isToObj() default true;
}
