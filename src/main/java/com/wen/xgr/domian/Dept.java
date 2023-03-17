package com.wen.xgr.domian;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

@XmlHead(value = "dept")
public class Dept {

    @XmlField(value = "deptId")
    private String deptId;

    @XmlField(value = "deptName")
    private String deptName;

    public Dept() {
    }

    public Dept(String deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
