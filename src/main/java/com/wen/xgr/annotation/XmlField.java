package com.wen.xgr.annotation;

import java.lang.annotation.*;

/**
 * @author wenting
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface XmlField {

    String value();

    int sort() default 0;

    String[] classTypeForName() default {};

    String classTypeAttribute() default "";

    String dateFormat() default "";

    boolean isToXml() default true;

    boolean isToObj() default true;
}
