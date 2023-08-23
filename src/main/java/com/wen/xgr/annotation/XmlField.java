package com.wen.xgr.annotation;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface XmlField {

    String value();

    int sort() default 0;

    String dateFormat() default "";

    boolean isToXml() default true;

    boolean isToObj() default true;
}
