/*
 * @(#) ClassLoaderDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-21
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.classloader;

import java.net.URL;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        URL url = ClassLoaderDemo.class.getResource("a.txt");
        System.out.println(url);
        URL url1 = ClassLoaderDemo.class.getClassLoader().getResource("com/ggd543/classloader/a.txt");
        System.out.println(url1);
        URL url2 = ClassLoaderDemo.class.getClassLoader().getResource("b.txt");
        System.out.println(url2);
        System.out.println(ClassLoaderDemo.class.getClassLoader().getResourceAsStream("b.txt"));
    }
}
