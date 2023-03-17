package com.wen.xgr.domian;

import com.wen.xgr.annotation.XmlField;
import com.wen.xgr.annotation.XmlHead;

import java.io.Serializable;
import java.util.*;

@XmlHead(value = "user")
public class User implements Serializable {

    @XmlField("id")
    private String id;

    @XmlField(value = "name")
    private String name;

    @XmlField("age")
    private Integer age;

    @XmlField("dept")
    private Dept dept;

    @XmlField(value = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @XmlField(value = "friend")
    private List<User> friend = new ArrayList<>();

    @XmlField(value = "map")
    private Map<String, String> map;

    @XmlField(value = "listmap")
    private List<Map<String, String>> listmap = new ArrayList<>();

    @XmlField(value = "orgNoList")
    private List<String> orgNoList = new ArrayList<>();

    public List<String> getOrgNoList() {
        return orgNoList;
    }

    public List<Map<String, String>> getListmap() {
        return listmap;
    }

    public void setListmap(List<Map<String, String>> listmap) {
        this.listmap = listmap;
    }

    public void setOrgNoList(List<String> orgNoList) {
        this.orgNoList = orgNoList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                ", birthday=" + birthday +
                ", friend=" + friend +
                ", map=" + map +
                ", listmap=" + listmap +
                ", orgNoList=" + orgNoList +
                '}';
    }
}
