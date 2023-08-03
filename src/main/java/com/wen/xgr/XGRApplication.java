package com.wen.xgr;

import com.wen.xgr.domian.Dept;
import com.wen.xgr.domian.KS;
import com.wen.xgr.domian.KsMain;
import com.wen.xgr.domian.User;
import com.wen.xgr.utils.XGRUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class XGRApplication {

    public static void main(String[] args) throws Exception {

        User user = new User("1", "张三", 18);
        user.getFriend().add(new User("2", "李四", 20));
        user.setDept(new Dept("3", "研发部"));
        user.getOrgNoList().add("admin");
        user.getOrgNoList().add("manager");
        user.getOrgNoList().add("worker");
        Map<String, String> map = new HashMap<>();
        map.put("abc", "123");
        user.setMap(map);
        Map<String, String> listmap1 = new HashMap<>();
        listmap1.put("name", "tom");
        Map<String, String> listmap2 = new HashMap<>();
        listmap2.put("age", "12");
        user.getListmap().add(listmap1);
        user.getListmap().add(listmap2);
        user.setBirthday(new Date());
        XGRUtil<User> util1 = new XGRUtil<>(User.class);
        String xml = util1.convertXML(user);
        System.out.println(xml);
        XGRUtil<User> util2 = new XGRUtil<>(User.class);
        User newUser = util2.convertObj(xml);
        System.out.println(newUser);

        XGRUtil<User> util3 = new XGRUtil<>(User.class);
        String s = util3.convertXML(newUser);
        System.out.println(s);
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
    }

}
