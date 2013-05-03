/*
 * @(#) SleepThread.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-25
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.jvm;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class SleepThread extends Thread {
    public SleepThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100000000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
