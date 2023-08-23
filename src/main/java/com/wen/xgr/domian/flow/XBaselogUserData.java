package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

@XmlHead(value = "XBaselogUserData")
public class XBaselogUserData extends Attributes {

    @Override
    public String toString() {
        return "XBaselogUserData{" +
                "headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }
}
