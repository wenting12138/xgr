package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

@XmlHead(value = "responseHandle")
public class ResponseHandle extends Attributes {

    @Override
    public String toString() {
        return "ResponseHandle{" +
                "headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }
}
