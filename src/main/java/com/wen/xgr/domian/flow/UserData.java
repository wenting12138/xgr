package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlHead;
import lombok.Data;
import lombok.ToString;

@XmlHead(value = "userData")
@Data
@ToString
public class UserData {

    @XmlAttribute("variableName")
    private String variableName;
    @XmlAttribute("variableValue")
    private String variableValue;


}
