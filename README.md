# xgr
java对象转xml
        User user = new User("1", "张三", 18);
        user.getFriend().add(new User("2", "李四", 20));
        user.setBirthday(new Date());
        XGRUtil<User> util = new XGRUtil<>(User.class);
        System.out.println(util.convertXML(user));
