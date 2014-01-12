package com.ggd543.demo;

import net.sf.ehcache.CacheManager;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-11
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
public class CacheApp {
    public static void main(String[] args) {
        CacheManager manager = CacheManager.getInstance();
        String[] names = manager.getCacheNames();
        for (String s : names) {
            System.out.println(s);
        }

        manager.shutdown();
    }
}
