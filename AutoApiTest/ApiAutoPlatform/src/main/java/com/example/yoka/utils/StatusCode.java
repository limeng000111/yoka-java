package com.example.yoka.utils;


import org.springframework.stereotype.Service;


public enum StatusCode {

    SUCCESS(200,"成功"),

    /**
     * 项目相关的返回码
     */
    NO_PROJECT(1001,"无该项目"),
    ADD_PROJECT_FAILED(1002,"项目新增失败"),
    EXIST_PROJECT(1003,"项目已存在"),
    UPDATE_PROJECT_FAILED(1004,"更新项目失败"),
    DELETE_PROJECT_FAILED(1005,"删除项目失败"),




    /**
     * 接口相关的返回码
     */
    EXIST_API(2001,"接口已存在"),
    QUERY_SINGLE_API_FAILED(2002,"查询接口失败"),
    QUERY_ALL_API_FAILED(2003,"查询接口列表失败"),
    ADD_API_FAILED(2004,"接口新增失败"),
    UPDATE_API_FAILED(2005,"接口更新失败");
    private int code;
    private String message;

    StatusCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
