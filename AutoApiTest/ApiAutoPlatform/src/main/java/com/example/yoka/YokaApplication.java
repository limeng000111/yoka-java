package com.example.yoka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"com.example.yoka.dao"})
@SpringBootApplication
public class YokaApplication {

    public static void main(String[] args) {

        SpringApplication.run(YokaApplication.class, args);
    }

}
