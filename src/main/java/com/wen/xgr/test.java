package com.wen.xgr;

import com.wen.xgr.domian.flow.BaseMenu;
import com.wen.xgr.domian.flow.Ivr;
import com.wen.xgr.domian.flow.IvrFlow;
import com.wen.xgr.utils.XGRUtil;

public class test {

    public static void main(String[] args) throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<IVR>\n" +
                "  <IVRHeader tenantid=\"default\" ivrEntryPoint=\"966880\" defaultIVRFlowID=\"753cb45861b44f1aa1b51fd80a77b5b3\"/>\n" +
                "  <IVRFlows>\n" +
                "    <IVRFlow ivrFlowID=\"753cb45861b44f1aa1b51fd80a77b5b3\" autoRecord=\"true\" ttsEngine=\"unimrcpserver-mrcp2-tts\" ttsVoiceName=\"RouMeiQian_E2E\" asrEngine=\"unimrcpserver-mrcp2-asr\" asrGrammar=\"SinoVoice\" startMenu=\"4509f1fc-02d7-432d-80d6-7e37f3b0c3fe\" endMenu=\"d4d4f9c6-b0d9-4ddc-8bc7-396df54e3e7f\" exitMenu=\"b8ce61c6-7ecc-411c-853e-3c96cafab75a\">\n" +
                "      <XBaselogUserData/>\n" +
                "      <menus>\n" +
                "\t\t  <menu type=\"VoiceMenu\" id=\"4509f1fc-02d7-432d-80d6-7e37f3b0c3fe\" name=\"按键跳转\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/111.wav\" maxFailures=\"3\" timeout=\"10\" maxTimeouts=\"3\" dynamicCallTTS=\"false\" interruptible=\"true\" interruptKey=\"\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" allowedInputDTMF=\"1,#\" resetToStart=\"false\" templateSceneId=\",\" maxFailuresTargetMenu=\"0682eca3-2593-4b40-a0e5-67cc5764a1d7\" maxTimeoutsTargetMenu=\"176e8d94-0c08-463a-80cd-90f544db043b\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<branches>\n" +
                "\t\t\t<branch dtmf=\"1\" targetMenu=\"6102dd0a-0d90-43d9-9cc7-cbe388ff603e\" targetName=\"智能IVR交互\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\"/>\n" +
                "\t\t\t<branch dtmf=\"#\" targetMenu=\"93eff79f-01df-4ec8-87e5-02be5a219167\" targetName=\"主菜单播报\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\"/>\n" +
                "\t\t\t</branches>\n" +
                "\t\t\t<condition/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"RouteRequestMenu\" id=\"e306d627-1c72-4ea0-87bf-c828503974bc\" name=\"转人工\" agentGroup=\"VQ_TEST_A\" needReport=\"false\" businessType=\"VQ_TEST_A\" routeType=\"freelink\" interval4agentBusy=\"30\" waitMusic=\"\" gRoutePoint=\"\" gProxyURL=\"\" channelType=\"\" chatUrl=\"\" findAgentTargetMenu=\"d4d4f9c6-b0d9-4ddc-8bc7-396df54e3e7f\" findAgentTargetMenuLabel=\"有空闲座席\" agentBusyTargetMenu=\"d5895a1e-6091-40fe-a9a1-39d692fadd3a\" agentBusyTargetMenuLabel=\"座席全忙\">\n" +
                "\t\t\t<userData variableName=\"userLevel\" variableValue=\"${data.clientInfo.level}\"/>\n" +
                "\t\t\t<newVariable variableName=\"busiType\" variableValue=\"zixun\"/>\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<condition needReport=\"false\"/>\n" +
                "\t\t  </menu>\n" +
                "\t  </menus>\n" +
                "    </IVRFlow>\n" +
                "  </IVRFlows>\n" +
                "</IVR>";

        XGRUtil<Ivr> util = new XGRUtil<>(Ivr.class);
        Ivr flow = util.convertObj(xml);
        System.out.println(flow.getIvrHeader());
        System.out.println(flow.getIvrFlows());
        for (IvrFlow ivrFlow : flow.getIvrFlows()) {
            for (BaseMenu menu : ivrFlow.getBaseMenuList()) {
                System.out.println(menu);
            }
        }
//
        XGRUtil<Ivr> util2 = new XGRUtil<>(Ivr.class);
        System.out.println(util2.convertXML(flow));

    }

}
