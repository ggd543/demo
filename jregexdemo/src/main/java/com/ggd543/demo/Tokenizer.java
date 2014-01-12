package com.ggd543.demo;

import jregex.Pattern;
import jregex.RETokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-7
 * Time: 下午4:34
 * To change this template use File | Settings | File Templates.
 */
public class Tokenizer {
    public static void main(String[] args) {
        String theText = " Some --- strings --- separated by \"---\"";
        Pattern p = new Pattern("(?<!\")---(?!\")"); //three hyphens not enclosed in quotemarks
        RETokenizer tok = new RETokenizer(p, theText);
        while (tok.hasMore()) {
            System.out.println("Next token: " + tok.nextToken());
        }

    }
}
