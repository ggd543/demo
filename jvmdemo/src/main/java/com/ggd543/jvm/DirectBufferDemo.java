/*
 * @(#) DirectBufferDemo.java
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
public class DirectBufferDemo {
    private static final int BLOCK_SIZE = 1 * 1024 * 1024;
    private static List<ByteBuffer> byteBufferList = new LinkedList<ByteBuffer>();

    /**
     * vm args: -Xmx20m -Xms20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:MaxDirectMemorySize=10M
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        int N = 10;
        for (; i <= N; i++) {
            ByteBuffer buf = ByteBuffer.allocateDirect(BLOCK_SIZE);
            byteBufferList.add(buf);
            System.out.println("i=" + i);
        }
        System.out.println("before clear byte buffer list ");
        byteBufferList.clear();
        System.out.println("byte buffer list clear");
        byte[] buf1 = new byte[7 * BLOCK_SIZE];
        System.out.println("7M object created");
        byte[] buf2 = new byte[7 * BLOCK_SIZE];
        System.out.println("7M object created");
        Thread.sleep(5000L);

        for (; i <= 2 * N; i++) {
            ByteBuffer buf = ByteBuffer.allocateDirect(BLOCK_SIZE);
            byteBufferList.add(buf);
//            ByteBuffer.allocate(BLOCK_SIZE);
            System.out.println("i=" + i);
        }
//        Thread.sleep(10* 1000L);
//        new BigObject();
//
//        System.gc();

    }
}

class BigObject {
    private static final int BLOCK_SIZE = 1 * 1024 * 1024;
    byte[] buf = new byte[7 * BLOCK_SIZE];


}