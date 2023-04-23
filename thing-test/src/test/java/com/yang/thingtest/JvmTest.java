package com.yang.thingtest;

import java.util.Random;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/10/30/23:15
 */
public class JvmTest {
    public static void main(String[] args) {
        String str = "hello world";
        while (true)
            str += str + new Random().nextInt(88888888) + new Random().nextInt(88888888);
    }
}
