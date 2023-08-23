package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

@XmlHead(value = "newVariable")
public class NewVariable extends Attributes {

    @Override
    public String toString() {
        return "NewVariable{" +
                "headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }
}
