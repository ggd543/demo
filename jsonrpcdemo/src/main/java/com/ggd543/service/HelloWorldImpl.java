/*
 * @(#) HelloWorldImpl.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-23
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.service;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class HelloWorldImpl implements HelloWorld   {
    public String sayHelloWorld(String name) {
        return "Hello World! hello, " + name;
    }

    @Override
    public User getUser(int id) {
        User user = new User();
        user.setId(id);
        user.setName("Archer");
        return user;
    }

    @Override
    public void sayHi(User user) {
        System.out.println("say hi to "+user);

    }
}
