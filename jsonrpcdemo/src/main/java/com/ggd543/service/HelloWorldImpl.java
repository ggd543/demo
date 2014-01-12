/*
 * @(#) HelloWorldImpl.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-23
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.service;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

import static com.ggd543.service.UserType.*;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class HelloWorldImpl implements HelloWorld {
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
        System.out.println("say hi to " + user);

    }

    private List<Book> queryBooks() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1, "Java", new User(1001, "Jack")));
        bookList.add(new Book(1, "C++", new User(1002, "Archer")));
        return bookList;
    }

    private List<User> queryUsers() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(12, "liu yongjian"));
        userList.add(new User(23, "lin xianke"));
        return userList;
    }

    public List query(int  userType) {
        List res = null;
        switch (userType) {
            case 0:
                res = queryBooks();
                break;
            case 1:
                res = queryUsers();
                break;
            default:
                System.out.println("Unknown user type: " + userType);
                throw new RuntimeException("unknown user type");
        }
        return res;
    }

    /**
     * json-rpc 不支持 枚举类
     * @param i
     * @return
     */
    public UserType getUserType(int i) {
        if (i == 0) {
            return UserType.USER;
        } else {
            return UserType.BOOK;
        }
    }
}
