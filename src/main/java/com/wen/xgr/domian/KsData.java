package com.wen.xgr.domian;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

import java.util.List;

@XmlHead("DATA")
public class KsData {

    @XmlField("DATAINFOS")
    private KS ks;

    public KS getKs() {
        return ks;
    }

    @Override
    public String toString() {
        return "KsData{" +
                "ks=" + ks +
                '}';
    }

    public void setKs(KS ks) {
        this.ks = ks;
    }

}
