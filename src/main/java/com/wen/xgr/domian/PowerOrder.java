package com.wen.xgr.domian;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

import java.util.Map;

@XmlHead("ORDER")
public class PowerOrder {

    @XmlField("servicecode")
    private String servicecode;
    @XmlField("source")
    private String source;
    @XmlField("target")
    private String target;
    @XmlField(value = "data")
    private PowerOff powerOff;

    private Map<String, String> headerAttrs;
    private Map<String, Map<String, String>> fieldsAttrs;

    public Map<String, String> getHeaderAttrs() {
        return headerAttrs;
    }

    public void setHeaderAttrs(Map<String, String> headerAttrs) {
        this.headerAttrs = headerAttrs;
    }

    public Map<String, Map<String, String>> getFieldsAttrs() {
        return fieldsAttrs;
    }

    public void setFieldsAttrs(Map<String, Map<String, String>> fieldsAttrs) {
        this.fieldsAttrs = fieldsAttrs;
    }

    @Override
    public String toString() {
        return "PowerOrder{" +
                "servicecode='" + servicecode + '\'' +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", powerOff=" + powerOff +
                ", headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public PowerOff getPowerOff() {
        return powerOff;
    }

    public void setPowerOff(PowerOff powerOff) {
        this.powerOff = powerOff;
    }
}
