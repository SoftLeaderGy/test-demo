package com.yang.threadtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ThreadTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadTestApplication.class, args);
    }

}
