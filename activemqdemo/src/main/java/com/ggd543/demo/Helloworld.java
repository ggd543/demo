package com.ggd543.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helloworld {
    private static  Logger logger = LoggerFactory.getLogger(Helloworld.class);

    public static void main(String[] args) {
        logger.info("before hello ...");
        System.out.println(hello());
        logger.info("after hello ...");
    }

    public static String hello() {
        return "hello world";
    }
}