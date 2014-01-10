package com.ggd543.demo;

import java.net.URL;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-9-11 Time: 上午10:28 To change this template use File |
 * Settings | File Templates.
 */
public class Cache1App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Cache1App start");
        URL url = Cache1App.class.getResource("/2_2_0/ehcache.xml");
        System.out.println("ehcache configuration url: " + url);
        CacheManager manager = CacheManager.create(url);
        Ehcache ehcache = manager.getCache("testCache");

        // Ehcache ehcache = manager.getCache("sampleReplicatedCache3");
        ehcache.put(new Element("1", 1));
        ehcache.put(new Element("2", 2));
        ehcache.put(new Element(null, 2));
        Element element = ehcache.get("2");
        System.out.println(element);
        
        while (true) {
            System.out.println(ehcache.getStatistics());
            Thread.sleep(2000L);
        }
        
        // manager
    }
}
