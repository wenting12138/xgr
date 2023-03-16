package com.wen.xgr.annotation;

import com.wen.xgr.inter.DefaultHandleAttr;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface XmlField {

    String value();

    int sort() default 0;

    String dateFormat() default "";

    Class<?> attr() default DefaultHandleAttr.class;

}
