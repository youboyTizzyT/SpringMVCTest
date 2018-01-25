package com.example.model;

import com.alibaba.fastjson.JSONObject;

//import com.alibaba.fastjson.JSONObject;
public abstract class AbstractPlayer {
    private Integer userId;

    private String userName;

    private Integer sex;

    private Integer age;

    private Integer passwd;

     private String location;


    public final Integer getUserId() {
        return userId;
    }

    public final void setUserId(Integer userId) {
        this.userId = userId;
    }

    public final String getUserName() {
        return userName;
    }

    public final void setUserName(String userName) {
        this.userName = userName;
    }

    public final Integer getPasswd() {
        return passwd;
    }

    public final void setPasswd(Integer passwd) {
        this.passwd = passwd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {


        return "{\"userId\":\""+this.userId+"\",\"userName\":\""+this.userName+"\",\"sex\":\""+this.sex+"\",\"age\":\""+this.age+"\",\"passwd\":\""+this.passwd+"\",\"location\":\""+this.location+"\"}";
    }
}
