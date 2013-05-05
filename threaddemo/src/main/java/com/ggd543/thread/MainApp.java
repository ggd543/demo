/*
 * @(#) MainApp.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-17
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.thread;

import java.io.IOException;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("create loop thread");
        System.out.println("create read thread");
        System.out.println("create sleep thread");
        System.out.println("create wait thread");
        System.out.println("create 2 synchronized threads making dead lock");

        Thread loopThread = new LoopThread();
        Thread readThread = new ReadThread();
        Thread sleepThread = new SleepThread();
        Thread waitThread = new WaitThread();
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread synThread1 = new SynchronizedThread(lock1,lock2);
        Thread synThread2 = new SynchronizedThread(lock2,lock1);

        loopThread.start();
        readThread.start();
        sleepThread.start();
        waitThread.start();
        synThread1.start();
        synThread2.start();

        Thread.sleep(5000);
        System.out.println();
        System.out.println("loop thread: " + loopThread.getState());
        System.out.println("read thread: " + readThread.getState());
        System.out.println("sleep thread: " + sleepThread.getState());
        System.out.println("wait thread: " + waitThread.getState());
        System.out.println("synchronized thread: "+synThread1.getState());
        System.out.println("synchronized thread: " + synThread2.getState());

        ConvertUtils.convert(new Object(), Object.class);
    }
}

class LoopThread extends Thread {

    public LoopThread() {
        super("loop thread");
    }

    @Override
    public void run() {
        while (true) {
            ;
        }
    }
}

class ReadThread extends Thread {
    public ReadThread() {
        super("read thread");
    }

    @Override
    public void run() {
        byte[] buf = new byte[1024];
        try {
            System.in.read(buf, 0, buf.length);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}


class SleepThread extends Thread {
    public SleepThread() {
        super("sleep thread");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

class WaitThread extends Thread {
    private Object lockObj = new Object();

    public WaitThread() {
        super("wait thread");
    }

    @Override
    public void run() {
        synchronized (lockObj) {
            try {
                lockObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}

class SynchronizedThread extends Thread {
    private Object lock1;
    private Object lock2;

    public SynchronizedThread(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            synchronized (lock2) {
                throw new RuntimeException("should not go into here ");
            }
        }
    }
}