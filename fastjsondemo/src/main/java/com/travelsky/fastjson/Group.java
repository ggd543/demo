/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package com.travelsky.fastjson;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/21
 */
public class Group {
    private List<User> users;
    private int id;
    private String name;


    public Group() {
        this.users = new LinkedList<User>();
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setName(String name) {
        this.name = name;
    }
}
