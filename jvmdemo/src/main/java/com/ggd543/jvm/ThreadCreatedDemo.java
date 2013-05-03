/*
 * @(#) ThreadCreatedDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-25
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
public class ThreadCreatedDemo {
    private static final int BLOCK_SIZE = 1 * 1024 * 1024;
    private static List<ByteBuffer> byteBufferList = new LinkedList<ByteBuffer>();

    /**
     * jvm args: -Xmx1583m -Xms1583m -XX:MaxPermSize=64m  -XX:MaxDirectMemorySize=2048m -Xss2048k
     *
     * @param args
     */
    public static void main(String[] args) {
        byteBufferList.add(ByteBuffer.allocate(BLOCK_SIZE * 1024));
        for (int i = 0; i < 300; i++) {
            new SleepThread("Thread-" + i).start();
            System.out.println("Thread-" + i + " created");
        }
    }
}
