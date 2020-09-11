package com.example.demo.User;


import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Generated;
import javax.persistence.*;

//使用JPA注解配置映射关系

@Entity//告诉JPA这是一个实体类
@Table(name="voted_recorde")
public class UserRecorde {
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键
    private int id;

    @Column(name = "phone")
    private String phone;


    @Column(name = "votetime")
    private String votetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVotetime() {
        return votetime;
    }

    public void setVotetime(String votetime) {
        this.votetime = votetime;
    }
}


