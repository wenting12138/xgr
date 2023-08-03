package com.wen.xgr.domian;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@XmlHead("DATAINFOS")
public class KS {

    @XmlField("PUUID")
    private String puuid;
    @XmlField("DATAINFO")
    private KsDataDetail datainfoList;

    @Override
    public String toString() {
        return "KS{" +
                "puuid='" + puuid + '\'' +
                ", datainfoList=" + datainfoList +
                '}';
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public KsDataDetail getDatainfoList() {
        return datainfoList;
    }

    public void setDatainfoList(KsDataDetail datainfoList) {
        this.datainfoList = datainfoList;
    }
}
