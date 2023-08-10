package com.wen.xgr;

import com.wen.xgr.domian.*;
import com.wen.xgr.utils.XGRUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class XGRApplication {

    public static void main(String[] args) throws Exception {

//        User user = new User("1", "张三", 18);
//        user.getFriend().add(new User("2", "李四", 20));
//        user.setDept(new Dept("3", "研发部"));
//        user.getOrgNoList().add("admin");
//        user.getOrgNoList().add("manager");
//        user.getOrgNoList().add("worker");
//        Map<String, String> map = new HashMap<>();
//        map.put("abc", "123");
//        user.setMap(map);
//        Map<String, String> listmap1 = new HashMap<>();
//        listmap1.put("name", "tom");
//        Map<String, String> listmap2 = new HashMap<>();
//        listmap2.put("age", "12");
//        user.getListmap().add(listmap1);
//        user.getListmap().add(listmap2);
//        user.setBirthday(new Date());
//        XGRUtil<User> util1 = new XGRUtil<>(User.class);
//        String xml = util1.convertXML(user);
//        System.out.println(xml);
//        XGRUtil<User> util2 = new XGRUtil<>(User.class);
//        User newUser = util2.convertObj(xml);
//        System.out.println(newUser);
//
//        XGRUtil<User> util3 = new XGRUtil<>(User.class);
//        String s = util3.convertXML(newUser);
//        System.out.println(s);
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<ESB>\n" +
//                "\t<DATA>\n" +
//                "\t\t<DATAINFOS>\n" +
//                "\t\t\t<PUUID>437922BA13334A7AA5F8DA55BFDF2F71</PUUID>\n" +
//                "\t\t\t<DATAINFO>\n" +
//                "\t\t\t\t<DESC1>交口县汇交加工店</DESC1>\n" +
//                "\t\t\t\t<DESC2></DESC2>\n" +
//                "\t\t\t\t<DESC3></DESC3>\n" +
//                "\t\t\t\t<DESC4>外部单位</DESC4>\n" +
//                "\t\t\t\t<DESC5>个体工商户</DESC5>\n" +
//                "\t\t\t\t<DESC6>92141130MA0M9F8Y62</DESC6>\n" +
//                "\t\t\t\t<DESC7>山西省</DESC7>\n" +
//                "\t\t\t\t<DESC9>王丽平</DESC9>\n" +
//                "\t\t\t\t<DESC10></DESC10\n" +
//                "\t\t\t\t><DESC11>0</DESC11>\n" +
//                "\t\t\t\t<DESC12>中国</DESC12>\n" +
//                "\t\t\t\t<DESC13>山西省吕梁市交口县</DESC13>\n" +
//                "\t\t\t\t<DESC17></DESC17>\n" +
//                "\t\t\t\t<DESC18>山西省吕梁市交口县</DESC18>\n" +
//                "\t\t\t\t<DESC19>山西省吕梁市交口县水头镇云梦街后峪村</DESC19>\n" +
//                "\t\t\t\t<DESC20></DESC20>\n" +
//                "\t\t\t\t<DESC21></DESC21>\n" +
//                "\t\t\t\t<DESC22></DESC22>\n" +
//                "\t\t\t\t<CODE>0034097</CODE>\n" +
//                "\t\t\t\t<UUID>C5A67CB504FD40339CAEFD1899484F63</UUID>\n" +
//                "\t\t\t\t<MNEMONICCODE>JKXHJJGD</MNEMONICCODE>\n" +
//                "\t\t\t</DATAINFO>\n" +
//                "\t\t</DATAINFOS>\n" +
//                "\t</DATA>\n" +
//                "</ESB>";
//        XGRUtil<KsMain> util = new XGRUtil<>(KsMain.class);
//        KsMain ks = util.convertObj(str);
//        System.out.println(ks.getKsData().getKs());
//
//        XGRUtil<KsMain> util2 = new XGRUtil<>(KsMain.class);
//        System.out.println(util2.convertXML(ks));

        String xmls =
                "<ORDER abc='123'>" +
                        "<servicecode qwe='456'>CMS101</servicecode>" +
                        "<source></source>" +
                        "<target>5040204</target>" +
                        "<data def='678'> " +
                        "   <msgId>PRSS_powerInfoInterFace_579b0318-8bd6-437f-b2f1-6df4c964e32b</msgId> " +
                        "   <poweroffId>5040220230720002</poweroffId> " +
                        "   <cmsid>5040220230720002</cmsid> " +
                        "   <startTime>2023-07-20 14:22:46</startTime> " +
                        "   <stopDate>2023-07-20 16:22:53</stopDate> " +
                        "   <orgNo>5040204</orgNo> " +
                        "   <typeCode>02</typeCode> " +
                        "   <poweroffReason>测试测试</poweroffReason> " +
                        "   <powerType>03</powerType> " +
                        "   <importantConsComm>无</importantConsComm> " +
                        "   <chgTypeCode>00</chgTypeCode> " +
                        "   <changedCause></changedCause> " +
                        "   <empNo></empNo> " +
                        "   <collTime>2023-07-20 14:24:17</collTime> " +
                        "   <issueChannel>IVR、95598网站、网上国网</issueChannel> " +
                        "   <areaDesc>重庆市【高新区】1、石桥铺（科园二路、科园三路）；【九龙坡区】：1、石桥铺（石新路）；2、杨家坪（坪正街）</areaDesc> " +
                        "   <powerOffArea>变电站名称:110kV陈家坪变电站;线路名称:10kV陈西一616;台区名称:10kV昭华箱式变电站、10kV富有大厦配电室1#变</powerOffArea> " +
                        "   <voltCode></voltCode>" +
                        "   <dayNightFlag>0</dayNightFlag> " +
                        "   <dayStop></dayStop> " +
                        "   <nightSend></nightSend> " +
                        "   <datalists> " +
                        "       <datalist> " +
                        "           <tgId>2014062710370169</tgId> " +
                        "           <tgName>电网_10kV昭华箱式变电站</tgName> " +
                        "           <stationName>电网_110kV陈家坪变电站</stationName> " +
                        "           <lineName>电网_10kV陈西一616</lineName> " +
                        "           <lineId>2014062710438049</lineId> " +
                        "       </datalist> " +
                        "       <datalist> " +
                        "           <tgId>2014062710359185</tgId> " +
                        "           <tgName>电网_10kV富有大厦配电室1#变</tgName> " +
                        "           <stationName>电网_110kV陈家坪变电站</stationName> " +
                        "           <lineName>电网_10kV陈西一616</lineName> " +
                        "           <lineId>2014062710438049</lineId> " +
                        "       </datalist> " +
                        "   </datalists>" +
                        "</data>" +
                "</ORDER>";

        XGRUtil<PowerOrder> xgrUtil = new XGRUtil<>(PowerOrder.class);
        PowerOrder powerOrder = xgrUtil.convertObj(xmls);
        System.out.println(powerOrder);
        System.out.println(powerOrder.getPowerOff());
//        System.out.println(powerOrder.getPowerOff().getPowerOffDataList());

        XGRUtil<PowerOrder> xgrUtil2 = new XGRUtil<>(PowerOrder.class);
        String s = xgrUtil2.convertXML(powerOrder);
        System.out.println(s);

    }

}
