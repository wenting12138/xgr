package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

import java.util.List;

@XmlHead(value = "IVR")
public class Ivr extends Attributes {

    @XmlField("IVRHeader")
    private IvrHeader ivrHeader;

    @XmlField("IVRFlows")
    private List<IvrFlow> ivrFlows;

    @Override
    public String toString() {
        return "Ivr{" +
                "ivrHeader=" + ivrHeader +
                ", ivrFlows=" + ivrFlows +
                ", headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }

    public IvrHeader getIvrHeader() {
        return ivrHeader;
    }

    public void setIvrHeader(IvrHeader ivrHeader) {
        this.ivrHeader = ivrHeader;
    }

    public List<IvrFlow> getIvrFlows() {
        return ivrFlows;
    }

    public void setIvrFlows(List<IvrFlow> ivrFlows) {
        this.ivrFlows = ivrFlows;
    }
}
