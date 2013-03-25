/*
 * @(#) UnicodeDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-04
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 见 <a href="http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html"/>
 * @author liuyongjian
 * @version 1.0
 */
public class UnicodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 在Java中，所有字符（包括汉字，日文，朝鲜语等）的字面量都是使用Unicode字符集进行编码的
        System.out.println((int) ('中'));  // 字符 '中'的unicode值是20013
        System.out.println((int) ('严'));  // 字符 '中'的unicode值是20013
        System.out.println((int) ('a'));  // 字符'a'的unicode值是97
        System.out.println(new String("中".getBytes("Unicode"), "Unicode"));
        System.out.println();

        byte[] unicodeBuf = "中".getBytes("Unicode");
        byte[] utf8Buf = "中".getBytes("UTF-8");
        byte[] gbkBuf = "中".getBytes("GBK");
        byte[] iso8859Buf = "中".getBytes("ISO-8859-1");
        byte[] utf16Buf = "中".getBytes("UTF-16");
        byte[] gb2312Buf = "中".getBytes("GB2312");
//        byte[] utf32Buf = "中".getBytes("UTF-32"); // Java不支持UTF-32字符集??
        System.out.println("'中' 字在不同编码体系下的字节表示: ");
        System.out.println("Unicode: " + Arrays.toString(unicodeBuf));
        System.out.println("UTF-8: " + Arrays.toString(utf8Buf));
        System.out.println("GBK: " + Arrays.toString(gbkBuf));
        System.out.println("ISO8859-1: " + Arrays.toString(iso8859Buf));  //
        System.out.println("UTF-16: " + Arrays.toString(utf16Buf));
        System.out.println("GB2312: " + Arrays.toString(gb2312Buf));

        System.out.println();
        // 因为ISO-8859-1编码不支持中文, 所以将一个中文字符按ISO-8859-1编码后，就无法再变回中文了
        System.out.println(new String("中".getBytes("ISO-8859-1"), "ISO-8859-1"));
        System.out.println();

        System.out.println(Arrays.toString("严".getBytes("Unicode")));
        System.out.println(Arrays.toString("严".getBytes("UTF-8")));
        System.out.println(Arrays.toString("a".getBytes("Unicode")));
        System.out.println(Arrays.toString("a".getBytes("UTF-8")));
    }
}
