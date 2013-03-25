/*
 * @(#) StringBytesDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-04
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543;

import java.io.UnsupportedEncodingException;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class StringBytesDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "中";
        System.out.println(utf8_utf8_utf8(msg));  // 乱码
        System.out.println(utf8_gbk_utf8(msg));  // 乱码
        System.out.println(gbk_utf8_gbk(msg));  // 乱码
        System.out.println();
        System.out.println((new String(msg.getBytes("GBK"), "GBK"))); // 正常,编解码一定要一致
        System.out.println();
        System.out.println(new String(new String(msg.getBytes("UTF-8"), "UTF-8").getBytes("GBK"), "GBK"));  // 正常
    }


    public static String utf8_utf8_utf8(String msg) throws UnsupportedEncodingException {
        return new String(new String(msg.getBytes("UTF-8"), "UTF-8").getBytes("UTF-8"), "UTF-8");  // 编解码不一致，就无法变回来了
    }

    public static String gbk_utf8_gbk(String msg) throws UnsupportedEncodingException {
        return new String(new String(msg.getBytes("GBK"), "UTF-8").getBytes("UTF-8"), "GBK"); // 编解码不一致，就无法变回来了
    }

    public static String utf8_gbk_utf8(String msg) throws UnsupportedEncodingException {
        return new String(new String(msg.getBytes("UTF-8"), "GBK").getBytes("GBK"), "UTF-8"); // 编解码不一致，就无法变回来了
    }
}
