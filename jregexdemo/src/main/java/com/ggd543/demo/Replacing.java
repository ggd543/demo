package com.ggd543.demo;

import jregex.Pattern;
import jregex.Replacer;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-7
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
public class Replacing {
    public static void main(String[] args) {
        Pattern p = new Pattern("(\\d\\d):(\\d\\d):(\\d\\d)");
        Replacer r = p.replacer("[hour=$1, minute=$2, second=$3]");
        //see also the constructor Replacer(Pattern,String,boolean)
        String result = r.replace("the time is 10:30:01");
        //gives "the time is [hour=10, minute=30, second=01]"
        System.out.println(result);
    }
}
