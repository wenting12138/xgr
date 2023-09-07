package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.annotation.XmlOrder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@XmlHead(value = "menu")
@Data
@ToString
public class BaseMenu implements Serializable {
    @XmlAttribute("id")
    @XmlOrder(1)
    private String id;
    @XmlAttribute("name")
    @XmlOrder(2)
    private String name;
    @XmlAttribute("type")
    @XmlOrder(3)
    private String type;
    @XmlAttribute("needReport")
    @XmlOrder(4)
    private String needReport;




    @XmlField(value = "XBaselogUserData")
    @XmlOrder(1)
    private XBaselogUserData xBaselogUserData;

    @XmlField(value = "condition")
    @XmlOrder(2)
    private Condition condition;

    @XmlField(value = "responseHandle")
    @XmlOrder(3)
    private ResponseHandle responseHandle;

    @XmlField(value = "newVariable")
    @XmlOrder(4)
    private NewVariable newVariable;
    @XmlField(value = "userData")
    @XmlOrder(5)
    private UserData userData;

    @XmlField(value = "branches")
    @XmlOrder(6)
    private List<Branch> branches;
}
