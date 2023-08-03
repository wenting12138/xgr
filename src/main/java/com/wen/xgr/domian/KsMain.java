package com.wen.xgr.domian;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

@XmlHead("ESB")
public class KsMain {

    @XmlField("DATA")
    private KsData ksData;

    @Override
    public String toString() {
        return "KsMain{" +
                "ksData=" + ksData +
                '}';
    }

    public KsData getKsData() {
        return ksData;
    }

    public void setKsData(KsData ksData) {
        this.ksData = ksData;
    }
}
