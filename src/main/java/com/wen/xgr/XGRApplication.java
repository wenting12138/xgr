package com.wen.xgr;

import com.wen.xgr.domian.Dept;
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
    }

}
