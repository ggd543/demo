/*
 * @(#) ObjectGCApp.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 13-4-15
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package performance;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class ObjectGCApp {

    public static void main(String[] args) {
        performance(100);
        performance(1000);
        performance(5000);

    }

    private static void performance(int n){
        System.out.println("N="+n);
        long t1 = System.nanoTime();  // 1s = 10^9 ns = 10^3 ms
        for (int i = 0; i < n; i++) {
            test1();
        }
        long t2 = System.nanoTime();
        System.out.println("test1: " + 1.0 * (t2 - t1) / 1000000 + " ms");

        long t3 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            test2();
        }
        long t4 = System.nanoTime();
        System.out.println("test2: " + 1.0 * (t4 - t3) / 1000000 + " ms");
        System.out.println();
    }
    private static void test1() {
        BigObject bigObject = new BigObject();
    }

    private static void test2() {
        new BigObject();
    }
}

class BigObject {
    private byte[] obj1 = new byte[1 * 1024 * 1024 ]; // 1M
    private byte[] obj2 = new byte[1* 1024 * 1024 ]; // 1M
    private byte[] obj3 = new byte[1* 1024 * 1024 ]; // 1M
    private byte[] obj4 = new byte[1* 1024 * 1024 ]; // 1M
}
