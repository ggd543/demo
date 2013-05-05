/*
 * @(#) ThreadDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-24
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.jvm;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class ThreadDemo {
    private static final int BLOCK_SIZE = 1 * 1024 * 1024;
    private static List<ByteBuffer> byteBufferList = new LinkedList<ByteBuffer>();

    /**
     * jvm args: -Xss1024k -Xmx1583m -Xms1583m -XX:MaxPermSize=64m  -XX:MaxDirectMemorySize=2048m
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            new SleepThread("thread-" + i).start();
            System.out.println("thread-" + i);
//            Thread.sleep(10L);
        }
        for (int i = 1; i < 100; i++) {
            byteBufferList.add(ByteBuffer.allocateDirect(BLOCK_SIZE));
        }
    }
}
