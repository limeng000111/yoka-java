package com.example.yoka.entity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//@Entity
public class Project {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String project_name;
    private String api_ip;
    private String moudle;
    private String create_time;
    private String update_time;

    public Project(Integer id, String project_name, String api_ip, String moudle, String create_time, String update_time) {
        this.id = id;
        this.project_name = project_name;
        this.api_ip = api_ip;
        this.moudle = moudle;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public Project() {
    }


    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", project_name='" + project_name + '\'' +
                ", api_ip='" + api_ip + '\'' +
                ", moudle='" + moudle + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getproject_name() {
        return project_name;
    }

    public void setproject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getApi_ip() {
        return api_ip;
    }

    public void setApi_ip(String api_ip) {
        this.api_ip = api_ip;
    }

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }
}
