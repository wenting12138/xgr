package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@XmlHead(value = "IVR")
@Data
@ToString
public class Ivr{

    @XmlField("IVRHeader")
    private IvrHeader ivrHeader;

    @XmlField("IVRFlows")
    private List<IvrFlow> ivrFlows;
}
