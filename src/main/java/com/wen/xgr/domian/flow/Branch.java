package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.annotation.XmlOrder;
import com.wen.xgr.utils.Attributes;
import lombok.Data;
import lombok.ToString;

/**
 * @author wenting
 */
@XmlHead(value = "branch")
@Data
@ToString
public class Branch{

    @XmlAttribute("dtmf")
    @XmlOrder(1)
    private String dtmf;
    @XmlAttribute("targetMenu")
    @XmlOrder(2)
    private String targetMenu;
    @XmlAttribute("targetName")
    @XmlOrder(3)
    private String targetName;
    @XmlAttribute("needReport")
    @XmlOrder(4)
    private String needReport;
    @XmlAttribute("needAsUserData")
    @XmlOrder(5)
    private String needAsUserData;
    @XmlAttribute("confirmed")
    @XmlOrder(6)
    private String confirmed;
    @XmlAttribute("selectItemVariable")
    @XmlOrder(7)
    private String selectItemVariable;
    @XmlAttribute("lastItem")
    @XmlOrder(8)
    private String lastItem;
    @XmlAttribute("nextItem")
    @XmlOrder(9)
    private String nextItem;

}
