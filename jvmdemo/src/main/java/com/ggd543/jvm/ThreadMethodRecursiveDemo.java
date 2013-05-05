/*
 * @(#) ThreadMethodRecursiveDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-26
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
public class ThreadMethodRecursiveDemo {
    private static List<ByteBuffer> bufferList = new LinkedList<ByteBuffer>();
    private static final int BLOCK_SIZE = 1 * 1024 * 1024; // 1M
    /**
     * jvm args: -Xms512m -Xmx512m -Xmn256m -XX:MaxPermSize=512m -Xss102400k
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        bufferList.add(ByteBuffer.allocate(BLOCK_SIZE * 1024));
        bufferList.add(ByteBuffer.allocate(BLOCK_SIZE * 512));
        Thread.sleep(30000L);
//        for (int i = 0; i < 100; i++) {
//            new RecursiveMethodThread("thread-" + i).start();
//        }
        new RecursiveMethodThread("thread-test").start();
    }
}

class RecursiveMethodThread extends Thread {

    public RecursiveMethodThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            test(0);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }catch (Throwable ee){
            try {
                Thread.sleep(10000000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }

    private void test(int i) throws InterruptedException {
        test(i + 1);
    }

}
