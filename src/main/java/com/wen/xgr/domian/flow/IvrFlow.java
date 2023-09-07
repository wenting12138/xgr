package com.wen.xgr.domian.flow;

import com.wen.xgr.annotation.XmlAttribute;
import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@XmlHead(value = "IVRFlow")
@Data
@ToString
public class IvrFlow {
    @XmlAttribute("ivrFlowID")
    private String ivrFlowId;
    @XmlAttribute("autoRecord")
    private String autoRecord;
    @XmlAttribute("ttsEngine")
    private String ttsEngine;
    @XmlAttribute("ttsVoiceName")
    private String ttsVoiceName;
    @XmlAttribute("asrEngine")
    private String asrEngine;
    @XmlAttribute("asrGrammar")
    private String asrGrammar;
    @XmlAttribute("startMenu")
    private String startMenu;
    @XmlAttribute("endMenu")
    private String endMenu;
    @XmlAttribute("exitMenu")
    private String exitMenu;

    @XmlField("XBaselogUserData")
    private XBaselogUserData xBaselogUserData;
    @XmlField(
            value = "menus",
            classTypeAttribute = "type",
            classTypeForName = {
                    "VoiceMenu:com.wen.xgr.domian.flow.menus.VoiceMenu",
                    "RouteRequestMenu:com.wen.xgr.domian.flow.menus.RouteRequestMenu"
            }
    )
    private List<BaseMenu> baseMenuList;
}
