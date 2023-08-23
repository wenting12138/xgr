package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.utils.Attributes;

import java.io.Serializable;
import java.util.List;

@XmlHead(value = "menu")
public class Menu extends Attributes implements Serializable {

    @XmlField(value = "XBaselogUserData")
    private XBaselogUserData xBaselogUserData;

    @XmlField(value = "condition")
    private Condition condition;

    @XmlField(value = "responseHandle")
    private ResponseHandle responseHandle;

    @XmlField(value = "newVariable")
    private NewVariable newVariable;

    @XmlField(value = "branches")
    private List<Branch> branches;

    @Override
    public String toString() {
        return "Menu{" +
                "xBaselogUserData=" + xBaselogUserData +
                ", condition=" + condition +
                ", responseHandle=" + responseHandle +
                ", newVariable=" + newVariable +
                ", branches=" + branches +
                ", headerAttrs=" + headerAttrs +
                ", fieldsAttrs=" + fieldsAttrs +
                '}';
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public NewVariable getNewVariable() {
        return newVariable;
    }

    public void setNewVariable(NewVariable newVariable) {
        this.newVariable = newVariable;
    }

    public XBaselogUserData getxBaselogUserData() {
        return xBaselogUserData;
    }

    public void setxBaselogUserData(XBaselogUserData xBaselogUserData) {
        this.xBaselogUserData = xBaselogUserData;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public ResponseHandle getResponseHandle() {
        return responseHandle;
    }

    public void setResponseHandle(ResponseHandle responseHandle) {
        this.responseHandle = responseHandle;
    }
}
