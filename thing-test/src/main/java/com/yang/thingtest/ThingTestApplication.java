package com.yang.thingtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.thingtest.dao")
public class ThingTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThingTestApplication.class, args);
    }

}
