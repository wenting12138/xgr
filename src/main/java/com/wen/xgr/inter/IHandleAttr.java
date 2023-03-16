package com.wen.xgr.inter;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import org.dom4j.Element;

import java.util.Map;

public interface IHandleAttr {

    Map<String, String> handleAttr(Element ele, Object obj);

}
