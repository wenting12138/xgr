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
public class VoiceMenu extends BaseMenu {

    @XmlAttribute("menuText")
    @XmlOrder(4)
    private String menuText;
    @XmlAttribute("maxFailures")
    @XmlOrder(5)
    private String maxFailures;
    @XmlAttribute("timeout")
    @XmlOrder(6)
    private String timeout;
    @XmlAttribute("dynamicCallTTS")
    @XmlOrder(7)
    private String dynamicCallTTS;
    @XmlAttribute("interruptible")
    @XmlOrder(8)
    private String interruptible;
    @XmlAttribute("interruptKey")
    @XmlOrder(9)
    private String interruptKey;
    @XmlAttribute("ttsMode")
    @XmlOrder(10)
    private String ttsMode;
    @XmlAttribute("menuTextEncodeType")
    @XmlOrder(11)
    private String menuTextEncodeType;
    @XmlAttribute("promptType")
    @XmlOrder(12)
    private String promptType;
    @XmlAttribute("positionX")
    @XmlOrder(13)
    private String positionX;
    @XmlAttribute("positionY")
    @XmlOrder(14)
    private String positionY;
    @XmlAttribute("fontSize")
    @XmlOrder(15)
    private String fontSize;
    @XmlAttribute("fontColor")
    @XmlOrder(16)
    private String fontColor;
    @XmlAttribute("specificAudio")
    @XmlOrder(17)
    private String specificAudio;
    @XmlAttribute("specificVideo")
    @XmlOrder(18)
    private String specificVideo;
    @XmlAttribute("textContentType")
    @XmlOrder(19)
    private String textContentType;
    @XmlAttribute("allowedInputDTMF")
    @XmlOrder(20)
    private String allowedInputDTMF;
    @XmlAttribute("resetToStart")
    @XmlOrder(21)
    private String resetToStart;
    @XmlAttribute("templateSceneId")
    @XmlOrder(22)
    private String templateSceneId;
    @XmlAttribute("maxFailuresTargetMenu")
    @XmlOrder(23)
    private String maxFailuresTargetMenu;
    @XmlAttribute("maxTimeoutsTargetMenu")
    @XmlOrder(24)
    private String maxTimeoutsTargetMenu;

}
