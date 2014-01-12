package com.ggd543.demo;

import jregex.MatchIterator;
import jregex.MatchResult;
import jregex.Matcher;
import jregex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-7
 * Time: 下午4:21
 * To change this template use File | Settings | File Templates.
 */
public class Searching {
    public static void main(String[] args) {
        Pattern p = new Pattern("\\w+"); //a word pattern
        Matcher m = p.matcher("abcdefg,hi,,j");
        MatchIterator mi = m.findAll();
        while (mi.hasMore()) {
            MatchResult mr = mi.nextMatch();
            System.out.println("a word found: " + mr.toString());
        }
    }

    private void test2(){

    }
}
