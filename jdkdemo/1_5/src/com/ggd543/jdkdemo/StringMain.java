package com.ggd543.jdkdemo;

public class StringMain{
   public static void main(String[] args) throws Exception{
		byte[] buf = "hello world".getBytes( "UTF-8");
		System.out.println(StringApp.bytes2String(buf));
   }
}