package com.yang.threadtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;

//@SpringBootTest
class ThreadTestApplicationTests {

    @Test
    void contextLoads() throws ParseException {
//        System.out.println(new Date());
//        Date orderTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-01-01 12:00:00");
//        System.out.println(new Date() + "");
//        System.out.println(orderTime);
//        System.out.println(new Date("Tue Aug 30 13:11:22 CST 2022"));
        boolean[] booleans = new boolean[10];
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }

}
