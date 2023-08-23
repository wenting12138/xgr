package com.wen.xgr.utils;

import java.util.Map;

public class Attributes {

    protected Map<String, String> headerAttrs;
    protected Map<String, Map<String, String>> fieldsAttrs;


    public Map<String, String> getHeaderAttrs() {
        return headerAttrs;
    }

    public void setHeaderAttrs(Map<String, String> headerAttrs) {
        this.headerAttrs = headerAttrs;
    }

    public Map<String, Map<String, String>> getFieldsAttrs() {
        return fieldsAttrs;
    }

    public void setFieldsAttrs(Map<String, Map<String, String>> fieldsAttrs) {
        this.fieldsAttrs = fieldsAttrs;
    }


}
