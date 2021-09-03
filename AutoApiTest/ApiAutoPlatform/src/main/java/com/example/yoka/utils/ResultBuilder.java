package com.example.yoka.utils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultBuilder<T> {

    private int code;

    private String message;

    private T result;

    private String responseTime;

//    public ResultBuilder(T data,int code,String message){
//        this.result = data;
//        this.code = code;
//        this.message = message;
//        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//    }

    public ResultBuilder(T data, StatusCode statusCode) {
        this.result = data;
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public ResultBuilder(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public JSONObject toJSONObject(){
        JSONObject out = new JSONObject();
        out.put("code",code);
        out.put("message",message);
        out.put("result",result);
        out.put("responseTime",responseTime);
        return out;
    }

    @Override
    public String toString(){
        return toJSONObject().toString();
    }
}
