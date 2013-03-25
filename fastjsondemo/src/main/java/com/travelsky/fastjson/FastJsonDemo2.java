/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package com.travelsky.fastjson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/21
 */
public class FastJsonDemo2 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", 12);
        jsonObj.put("name", "archer");
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        jsonObj.putAll(map);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(new User(1, "Jack"));
        jsonArray.add(new User(2, "Mary"));
        jsonObj.put("users", jsonArray);
        System.out.println(jsonObj.toJSONString());
    }

    private static void test2() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(new User(1,"archer"));
        jsonArray.add(2);
        System.out.println(jsonArray.toJSONString());
        System.out.println(JSON.toJSONString(jsonArray,true));
    }

    private static void test3(){
        System.out.println(null  == JSON.toJSONString(null));

    }
}
