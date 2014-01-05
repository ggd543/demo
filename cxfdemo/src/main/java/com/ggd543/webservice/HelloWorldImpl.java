package com.ggd543.webservice;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-5
 * Time: 下午7:16
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldImpl implements HelloWorld  {
    @Override
    public String sayHello(String name) {
        System.out.println("invoke HelloWorldImpl.sayHello ... ");
        return "Hello world!";
    }
}
