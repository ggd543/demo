package com.ggd543.classloader;

/**
 * Created by ggd543 on 14-1-6.
 */
public class Hello {

    public void print(IHello h){
        System.out.println("hello classloader: "+getClass().getClassLoader()+" hello classloader: "+h.getClass().getClassLoader());
    }

    public void printDate(java.util.Date d){
        System.out.println(d);
    }
}
