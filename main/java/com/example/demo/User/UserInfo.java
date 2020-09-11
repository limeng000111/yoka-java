package com.example.demo.User;


import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Generated;
import javax.persistence.*;

//使用JPA注解配置映射关系

@Entity//告诉JPA这是一个实体类
@Table(name="voter_test")
public class UserInfo {
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column
    private String passwd;

    @Column
    private String email;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Column
    private String time;


//    @Id//这是一个主键
//    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIphone() {
        return phone;
    }

    public void setIphone(String iphone) {
        this.phone = iphone;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
