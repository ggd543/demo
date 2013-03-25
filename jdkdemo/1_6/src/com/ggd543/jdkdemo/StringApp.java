package com.ggd543.jdkdemo;

import java.nio.charset.*;

public class StringApp{
   public static String bytes2String(byte[] buf) throws Exception{
       return new String(buf, Charset.forName("UTF-8"));
// 	    return new String(buf, "UTF-8");
   }
    
   
   public static void main(String[] args) throws Exception{
        System.out.println(bytes2String("hello world".getBytes(Charset.forName("UTF-8"))));
	  //  System.out.println(bytes2String("hello world".getBytes("UTF-8")));
   }
   
}