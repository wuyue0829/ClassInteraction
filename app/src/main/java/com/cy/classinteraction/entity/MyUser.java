package com.cy.classinteraction.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by wuyue on 2016/3/23.
 */

@DatabaseTable(tableName = "user")
public class MyUser extends BmobUser implements Serializable{
    private static final long serialVersionUID = 1L;
    private MyUser(){

    }

    private MyUser(Boolean sex,String nick,Integer age,String photoUrl){
        this.sex = sex;
        this.age = age;
        this.nick = nick;
        this.photoUrl = photoUrl;
    }

    @DatabaseField
    private Boolean sex;
    @DatabaseField
    private String nick;
    @DatabaseField
    private Integer age;

    private BmobFile photo;
    @DatabaseField
    private String  photoUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BmobFile getPhoto() {
        return photo;
    }

    public void setPhoto(BmobFile photo) {
        this.photo = photo;
    }
}
