/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package com.travelsky.fastjson;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/21
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
}
