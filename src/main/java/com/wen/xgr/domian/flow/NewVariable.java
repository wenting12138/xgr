package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;
import lombok.Data;
import lombok.ToString;

@XmlHead(value = "newVariable")
@Data
@ToString
public class NewVariable{

    @XmlAttribute("variableName")
    private String variableName;
    @XmlAttribute("variableValue")
    private String variableValue;


}
