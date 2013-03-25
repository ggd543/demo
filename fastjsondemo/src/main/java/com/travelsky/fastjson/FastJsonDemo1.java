/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package com.travelsky.fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/21
 */
public class FastJsonDemo1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Group group = new Group();
        group.setId(0);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3);
        rootUser.setName("root");

        group.getUsers().add(guestUser);
        group.getUsers().add(rootUser);
        String jsonString = JSON.toJSONString(group);
        System.out.println(jsonString);
    }
}
