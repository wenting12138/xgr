package com.wen.xgr.domian;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

import java.util.*;

@XmlHead(value = "user")
public class User {

    @XmlField("id")
    private String id;

    @XmlField(value = "name")
    private String name;

    @XmlField("age")
    private Integer age;

    @XmlField("dept")
    private Dept dept = new Dept("1", "研发部");

    @XmlField(value = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @XmlField("friend")
    private List<User> friend = new ArrayList<>();

    @XmlField("map")
    private Map<String, String> map = new HashMap(){
        {
            put("123", "456");
        }
    };

    public User() {
    }

    public User(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<User> getFriend() {
        return friend;
    }

    public void setFriend(List<User> friend) {
        this.friend = friend;
    }
}
