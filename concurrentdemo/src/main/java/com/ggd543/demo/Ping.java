package com.ggd543.demo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-14
 * Time: 下午5:28
 * To change this template use File | Settings | File Templates.
 */


import java.util.concurrent.*;

public class Ping {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Runnable pinger = new Runnable() {
            public void run() {
                System.out.println("PING!");
            }
        };
        ses.scheduleAtFixedRate(pinger, 5, 5, TimeUnit.SECONDS);
    }

//    ConcurrentLinkedQueue;
//    LinkedBlockingQueue
}