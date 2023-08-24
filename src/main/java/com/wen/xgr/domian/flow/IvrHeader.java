package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;
import lombok.Data;
import lombok.ToString;

@XmlHead(value = "IVRHeader")
@Data
@ToString
public class IvrHeader {

    @XmlAttribute("tenantid")
    private String tenantid;
    @XmlAttribute("ivrEntryPoint")
    private String ivrEntryPoint;
    @XmlAttribute("defaultIVRFlowID")
    private String defaultIVRFlowID;
}
