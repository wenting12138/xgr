package com.wen.xgr.inter;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Map;

public class DefaultHandleAttr implements IHandleAttr{
    @Override
    public Map<String, String> handleAttr(Element ele, Object obj) {
        return new HashMap<>();
    }
}
