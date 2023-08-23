package com.wen.xgr;

import com.wen.xgr.domian.flow.Ivr;
import com.wen.xgr.domian.flow.IvrFlow;
import com.wen.xgr.domian.flow.Menu;
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
                "\t\t\t<branch dtmf=\"1\" targetMenu=\"6102dd0a-0d90-43d9-9cc7-cbe388ff603e\" targetName=\"智能IVR交互\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\"/>\n" +
                "\t\t\t<branch dtmf=\"#\" targetMenu=\"93eff79f-01df-4ec8-87e5-02be5a219167\" targetName=\"主菜单播报\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\"/>\n" +
                "\t\t\t<condition/>\n" +
                "\t\t\t<condition/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"SmartIVRMenu\" id=\"6102dd0a-0d90-43d9-9cc7-cbe388ff603e\" name=\"智能IVR交互\" url=\"http://10.5.2.40:10091/idp/v1/robot/JieTong/query\" nlpVendor=\"sinovoice\" ttsEngine=\"unimrcp:unimrcpserver-mrcp2-tts\" ttsVoiceName=\"RouMeiQian_E2E\" asrEngine=\"unimrcp:unimrcpserver-mrcp2-asr\" asrProfile=\"\" asrGrammar=\"SinoVoice\" init=\"1\" initInput=\"start\" initInputType=\"\" toAgentMenuId=\"93eff79f-01df-4ec8-87e5-02be5a219167\" systemErrorTargetMenu=\"\" nlpFailedTargetMenu=\"\" asrNoResultOperation=\"RepeatLasrPromt\" maxAsrNoResultTimes=\"3\" needReport=\"false\">\n" +
                "\t\t\t<asrParam variableName=\"no-input-timeout\" variableValue=\"50000\"/>\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"VoiceMenu\" id=\"93eff79f-01df-4ec8-87e5-02be5a219167\" name=\"主菜单播报\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/00/00/5dpSpfBaZx.wav\" maxFailures=\"3\" timeout=\"10\" maxTimeouts=\"3\" dynamicCallTTS=\"false\" interruptible=\"true\" interruptKey=\"\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" allowedInputDTMF=\"0,1,2,3,4,5,6,7,8\" resetToStart=\"false\" templateSceneId=\",\" maxTimeoutsTargetMenu=\"176e8d94-0c08-463a-80cd-90f544db043b\" maxFailuresTargetMenu=\"0682eca3-2593-4b40-a0e5-67cc5764a1d7\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<branch dtmf=\"2\" targetMenu=\"0973bf58-9111-4a37-8540-b82247f018f7\" targetName=\"工作时间判断\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\"/>\n" +
                "\t\t\t<condition/>\n" +
                "\t\t\t<condition/>\n" +
                "\t\t\t<branch dtmf=\"0\" targetMenu=\"6a297763-df64-4222-8650-d7160461e0e3\" targetName=\"转人工\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\">\n" +
                "\t\t\t  <newVariable variableName=\"busiType\" variableValue=\"zixun\"/>\n" +
                "\t\t\t</branch>\n" +
                "\t\t\t<branch dtmf=\"8\" targetMenu=\"16d16853-3fca-4e45-8519-e2d074772831\" targetName=\"转人工-投诉\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\">\n" +
                "\t\t\t  <newVariable variableName=\"busiType\" variableValue=\"tousu\"/>\n" +
                "\t\t\t</branch>\n" +
                "\t\t\t<branch dtmf=\"1\" targetMenu=\"e56a1dfd-f154-4a24-8cc0-d73f5b9b19f9\" targetName=\"输入身份证号\" needReport=\"false\" needAsUserData=\"true\" confirmed=\"false\" selectItemVariable=\"\" lastItem=\"false\" nextItem=\"false\"/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"BusinessQueryMenu\" id=\"0973bf58-9111-4a37-8540-b82247f018f7\" name=\"工作时间判断\" url=\"http://10.5.2.44:9090/eurm/if/iam/orgworktime/queryWorkStatusByNumber.ptc\" method=\"GET\" waitMusic=\"\" needReport=\"false\">\n" +
                "\t\t\t<requestParam paramName=\"number\" value=\"${Caller-RDNIS}\"/>\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<responseHandle targetMenu=\"195a897b-99a3-456c-83af-b2c9c7a54a37\" attributeName=\"info.data.isWork\" attributeValue=\"false\" default=\"true\" targetName=\"时间提示\" needReport=\"false\"/>\n" +
                "\t\t\t<condition/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"PlaybackMenu\" id=\"195a897b-99a3-456c-83af-b2c9c7a54a37\" name=\"时间提示\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/68.wav\" interruptible=\"true\" interruptKey=\"\" dynamicCallTTS=\"false\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"specificAudio\" templateSceneId=\",\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"ExitMenu\" id=\"176e8d94-0c08-463a-80cd-90f544db043b\" name=\"最大输入次数\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/51.wav\" interruptible=\"true\" interruptKey=\"\" dynamicCallTTS=\"false\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" templateSceneId=\",\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"ExitMenu\" id=\"d8c475cb-610e-4cb3-87cb-602c1575f8cb\" name=\"最大错误次数\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/51.wav\" interruptible=\"true\" interruptKey=\"\" dynamicCallTTS=\"false\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" templateSceneId=\",\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"ExitMenu\" id=\"3c834589-41e0-4c3a-8991-a59ff2ccfbc4\" name=\"多次输入超时挂机\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/51.wav\" interruptible=\"true\" interruptKey=\"\" dynamicCallTTS=\"false\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" templateSceneId=\",\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"ExitMenu\" id=\"0682eca3-2593-4b40-a0e5-67cc5764a1d7\" name=\"超时\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/50.wav\" interruptible=\"true\" interruptKey=\"\" dynamicCallTTS=\"false\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" templateSceneId=\",\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"PlaybackMenu\" id=\"b8ce61c6-7ecc-411c-853e-3c96cafab75a\" name=\"全局异常\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/51.wav\" interruptible=\"true\" interruptKey=\"\" dynamicCallTTS=\"false\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"specificAudio\" templateSceneId=\",\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"RouteRequestMenu\" id=\"6a297763-df64-4222-8650-d7160461e0e3\" name=\"转人工\" agentGroup=\"VQ_TEST_A\" needReport=\"false\" businessType=\"VQ_TEST_A\" routeType=\"freelink\" interval4agentBusy=\"30\" waitMusic=\"\" gRoutePoint=\"\" gProxyURL=\"\" channelType=\"\" chatUrl=\"\" findAgentTargetMenu=\"d4d4f9c6-b0d9-4ddc-8bc7-396df54e3e7f\" findAgentTargetMenuLabel=\"有空闲座席\" agentBusyTargetMenu=\"d5895a1e-6091-40fe-a9a1-39d692fadd3a\" agentBusyTargetMenuLabel=\"座席全忙\">\n" +
                "\t\t\t<userData variableName=\"userLevel\" variableValue=\"${data.clientInfo.level}\"/>\n" +
                "\t\t\t<newVariable variableName=\"businessType\" variableValue=\"zixun\"/>\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<condition needReport=\"false\"/>\n" +
                "\t\t\t<condition needReport=\"false\"/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"FindAgentMenu\" id=\"d4d4f9c6-b0d9-4ddc-8bc7-396df54e3e7f\" name=\"转接人工\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/89.wav\" interruptible=\"true\" interruptKey=\"\" dynamicCallTTS=\"false\" ttsMode=\"\" menuTextEncodeType=\"\" needReport=\"false\" forceNewConference=\"true\" templateSceneId=\",\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\">\n" +
                "\t\t\t<userData variableName=\"skillType\" variableValue=\"${header.businessType}\"/>\n" +
                "\t\t\t<userData variableName=\"busiType\" variableValue=\"${busiType}\"/>\n" +
                "\t\t\t<userData variableName=\"documentId\" variableValue=\"${idNumber}\"/>\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"AgentBusyMenu\" id=\"d5895a1e-6091-40fe-a9a1-39d692fadd3a\" name=\"坐席全忙\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/13.wav\" maxFailures=\"3\" timeout=\"10\" maxTimeouts=\"3\" dynamicCallTTS=\"false\" interruptible=\"true\" ttsMode=\"\" interruptKey=\"\" menuTextEncodeType=\"\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" templateSceneId=\",\" findAgentTargetMenu=\"d4d4f9c6-b0d9-4ddc-8bc7-396df54e3e7f\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"RouteRequestMenu\" id=\"16d16853-3fca-4e45-8519-e2d074772831\" name=\"转人工-投诉\" agentGroup=\"zixun\" needReport=\"false\" businessType=\"zixun\" routeType=\"freelink\" interval4agentBusy=\"30\" waitMusic=\"\" gRoutePoint=\"\" gProxyURL=\"\" channelType=\"\" chatUrl=\"\" findAgentTargetMenu=\"d4d4f9c6-b0d9-4ddc-8bc7-396df54e3e7f\" findAgentTargetMenuLabel=\"有空闲座席\" agentBusyTargetMenu=\"d5895a1e-6091-40fe-a9a1-39d692fadd3a\" agentBusyTargetMenuLabel=\"座席全忙\">\n" +
                "\t\t\t<userData variableName=\"userLevel\" variableValue=\"${data.clientInfo.level}\"/>\n" +
                "\t\t\t<newVariable variableName=\"businessType\" variableValue=\"tousu\"/>\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<condition needReport=\"false\"/>\n" +
                "\t\t\t<condition needReport=\"false\"/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"VoiceOrCollectMenu\" id=\"e56a1dfd-f154-4a24-8cc0-d73f5b9b19f9\" name=\"输入身份证号\" menuText=\"http://10.5.2.44:9090/fileserver/get?filename=/ivr/52.wav\" maxFailures=\"3\" timeout=\"10\" maxTimeouts=\"3\" dynamicCallTTS=\"false\" interruptible=\"true\" interruptKey=\"\" ttsMode=\"\" menuTextEncodeType=\"\" storageParam=\"idNumber\" minLength=\"18\" maxLength=\"19\" terminateChar=\"#\" needReport=\"false\" promptType=\"audio\" positionX=\"\" positionY=\"\" fontSize=\"\" fontColor=\"\" specificAudio=\"\" specificVideo=\"\" textContentType=\"\" templateSceneId=\",\" succeedTargetMenu=\"e306d627-1c72-4ea0-87bf-c828503974bc\">\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<condition/>\n" +
                "\t\t  </menu>\n" +
                "\t\t  <menu type=\"RouteRequestMenu\" id=\"e306d627-1c72-4ea0-87bf-c828503974bc\" name=\"转人工\" agentGroup=\"VQ_TEST_A\" needReport=\"false\" businessType=\"VQ_TEST_A\" routeType=\"freelink\" interval4agentBusy=\"30\" waitMusic=\"\" gRoutePoint=\"\" gProxyURL=\"\" channelType=\"\" chatUrl=\"\" findAgentTargetMenu=\"d4d4f9c6-b0d9-4ddc-8bc7-396df54e3e7f\" findAgentTargetMenuLabel=\"有空闲座席\" agentBusyTargetMenu=\"d5895a1e-6091-40fe-a9a1-39d692fadd3a\" agentBusyTargetMenuLabel=\"座席全忙\">\n" +
                "\t\t\t<userData variableName=\"userLevel\" variableValue=\"${data.clientInfo.level}\"/>\n" +
                "\t\t\t<newVariable variableName=\"busiType\" variableValue=\"zixun\"/>\n" +
                "\t\t\t<XBaselogUserData/>\n" +
                "\t\t\t<condition needReport=\"false\"/>\n" +
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
            System.out.println(ivrFlow);

            for (Menu menu : ivrFlow.getMenuList()) {
                System.out.println(menu);
            }
        }

        XGRUtil<Ivr> util2 = new XGRUtil<>(Ivr.class);
        System.out.println(util2.convertXML(flow));

    }

}
