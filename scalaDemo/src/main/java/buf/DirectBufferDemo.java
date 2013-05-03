/*
 * @(#) DirectBufferDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-22
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package buf;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class DirectBufferDemo {
    private static List<ByteBuffer> byteBufferList = new LinkedList<ByteBuffer>();
    private static int BLOCK_SIZE = 1 * 1024 * 1024; // 1M

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ByteBuffer.allocateDirect(BLOCK_SIZE);
//            ByteBuffer buf = ByteBuffer.allocateDirect(BLOCK_SIZE);
//            byteBufferList.add(buf);
//            System.out.println(i + " - allocate 1M ");
        }
    }

}


