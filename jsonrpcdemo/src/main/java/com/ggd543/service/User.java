package com.ggd543.service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-2
 * Time: 下午5:18
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("user[id: %d, name: %s]", id, name);
    }
}
