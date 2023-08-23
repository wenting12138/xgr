package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

@XmlHead(value = "condition")
public class Condition extends Attributes {

    @Override
    public String toString() {
        return "Condition{" +
                "headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }
}
