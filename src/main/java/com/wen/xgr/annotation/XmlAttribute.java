package com.wen.xgr.annotation;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface XmlAttribute {
    String value();

}
