/*
 * @(#) ClassLoaderDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-21
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
//        testFindResource();
        System.out.println(Date.class.getClassLoader());
        System.out.println(IHello.class.getClassLoader());
        testLoadClass();
    }

    private static void testLoadClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CustomClassLoader loader1 =new CustomClassLoader();
        Class clazz1 = loader1.loadClass("com.ggd543.classloader.Hello");
        Object instance1= clazz1.newInstance();
//        IHello iHello = (IHello) instance1;
        SubCustomClassLoader loader2 =new SubCustomClassLoader();
        Class clazz2 = loader2.loadClass("com.ggd543.classloader.Hello");
        Object instance2= clazz2.newInstance();

        Method method1= clazz1.getMethod("printDate", Date.class);
        method1.invoke(instance1,new Date());
//        Method method1 = clazz1.getMethod("print", instance2.getClass());
//        Method method1 = clazz1.getMethod("print", IHello.class);
//        method1.invoke(instance1,instance1);

//        Method method2 =  clazz2.getMethod("print", clazz2);
//        method2.invoke(instance2, instance1 );

    }

    private static void testFindResource() {
        URL url = ClassLoaderDemo.class.getResource("a.txt");
        System.out.println(url);
        URL url1 = ClassLoaderDemo.class.getClassLoader().getResource("com/ggd543/classloader/a.txt");
        System.out.println(url1);
        URL url2 = ClassLoaderDemo.class.getClassLoader().getResource("b.txt");
        System.out.println(url2);
        System.out.println(ClassLoaderDemo.class.getClassLoader().getResourceAsStream("b.txt"));
    }
}
