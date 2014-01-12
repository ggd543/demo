/*
 * @(#) Helloworld.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-23
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.service;

import java.util.Collection;
import java.util.List;

/**
 * @author liuyongjian
 * @version 1.0
 */
public interface HelloWorld {
    public String sayHelloWorld(String name);
    public User getUser(int id);

    public void sayHi(User user);

    public List query(int i);

    public UserType getUserType(int i);
}
