package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;
import lombok.Data;
import lombok.ToString;

@XmlHead(value = "condition")
@Data
@ToString
public class Condition{

    @XmlAttribute("needReport")
    private String needReport;

}
