package com.example.yoka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan("com.example.yoka.entity")
public class YokaApplication {

    public static void main(String[] args) {

        SpringApplication.run(YokaApplication.class, args);
    }

}
