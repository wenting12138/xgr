package com.wen.xgr.domian.flow.menus;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlHead;
import com.wen.xgr.annotation.XmlOrder;
import com.wen.xgr.domian.flow.BaseMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@XmlHead(value = "menu")
@Data
@ToString(callSuper = true)
public class RouteRequestMenu extends BaseMenu {

    @XmlAttribute("agentGroup")
    @XmlOrder(5)
    private String agentGroup;

    @XmlAttribute("businessType")
    @XmlOrder(6)
    private String businessType;

    @XmlAttribute("routeType")
    @XmlOrder(7)
    private String routeType;

    @XmlAttribute("interval4agentBusy")
    @XmlOrder(8)
    private String interval4agentBusy;
    @XmlAttribute("waitMusic")
    @XmlOrder(9)
    private String waitMusic;
    @XmlAttribute("gRoutePoint")
    @XmlOrder(10)
    private String gRoutePoint;
    @XmlAttribute("gProxyURL")
    @XmlOrder(11)
    private String gProxyURL;
    @XmlAttribute("channelType")
    @XmlOrder(12)
    private String channelType;
    @XmlAttribute("chatUrl")
    @XmlOrder(13)
    private String chatUrl;
    @XmlAttribute("findAgentTargetMenu")
    @XmlOrder(14)
    private String findAgentTargetMenu;
    @XmlAttribute("findAgentTargetMenuLabel")
    @XmlOrder(15)
    private String findAgentTargetMenuLabel;
    @XmlAttribute("agentBusyTargetMenu")
    @XmlOrder(16)
    private String agentBusyTargetMenu;
    @XmlAttribute("agentBusyTargetMenuLabel")
    @XmlOrder(17)
    private String agentBusyTargetMenuLabel;

}
