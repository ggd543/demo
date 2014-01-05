package com.ggd543.service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-2
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    public int cn;
    public String name;
    public User author;

    public Book() {
    }

    public Book(int cn, String name, User author) {
        this.cn = cn;
        this.name = name;
        this.author = author;
    }
}
