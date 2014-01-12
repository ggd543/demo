package com.ggd543.demo;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-11
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public class Cache2App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Cache2App start");
        URL url  = Cache1App.class.getResource("/2_2_0/ehcache.xml");
        CacheManager manager = CacheManager.create(url);
        Ehcache ehcache = manager.getCache("testCache");
//        Ehcache ehcache = manager.getCache("sampleReplicatedCache3");
        ehcache.put(new Element("1",1));
//        ehcache.put(new Element("2",2));
        while (true) {
            System.out.println(ehcache.getStatistics());
//            ehcache.put(new Element("a", "aa"));
//            ehcache.put(new Element("1",new NonSerializableObject()));
            Thread.sleep(2000L);
        }

//        Thread.sleep(10000L);
//        manager
    }
}
