package com.wen.xgr;

import com.wen.xgr.domian.User;
import com.wen.xgr.utils.XGRUtil;

import java.util.Date;

public class XGRApplication {

    public static void main(String[] args) throws Exception {

        User user = new User("1", "张三", 18);
        user.getFriend().add(new User("2", "李四", 20));
        user.setBirthday(new Date());
        XGRUtil<User> util = new XGRUtil<>(User.class);
        System.out.println(util.convertXML(user));

    }

}
