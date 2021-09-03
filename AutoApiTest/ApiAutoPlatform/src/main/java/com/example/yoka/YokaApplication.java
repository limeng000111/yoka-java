package com.example.yoka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableRetry
@EnableOpenApi
@SpringBootApplication
//@ComponentScan("com.example.yoka.entity")
@MapperScan("com.example.yoka.dao")
public class YokaApplication {

    public static void main(String[] args) {

        SpringApplication.run(YokaApplication.class, args);
    }

}
