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
    @XmlAttribute("menuText")
    @XmlOrder(4)
    private String menuText;
    @XmlAttribute("maxFailures")
    @XmlOrder(5)
    private String maxFailures;
    @XmlAttribute("timeout")
    @XmlOrder(6)
    private String timeout;

    @XmlField(value = "XBaselogUserData")
    @XmlOrder(8)
    private XBaselogUserData xBaselogUserData;

    @XmlField(value = "condition")
    @XmlOrder(7)
    private Condition condition;

    @XmlField(value = "responseHandle")
    @XmlOrder(9)
    private ResponseHandle responseHandle;

    @XmlField(value = "newVariable")
    @XmlOrder(10)
    private NewVariable newVariable;
    @XmlField(value = "userData")
    @XmlOrder(12)
    private UserData userData;

    @XmlField(value = "branches")
    @XmlOrder(11)
    private List<Branch> branches;
}
