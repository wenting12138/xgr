package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

@XmlHead(value = "branch")
public class Branch extends Attributes {

    @Override
    public String toString() {
        return "Branch{" +
                "headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }
}
