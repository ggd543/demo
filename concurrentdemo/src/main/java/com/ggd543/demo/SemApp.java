package com.ggd543.demo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-14
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;
import java.util.concurrent.*;

public class SemApp {
    public static void main(String[] args) {
        Runnable limitedCall = new Runnable() {
            final Random rand = new Random();
            final Semaphore available = new Semaphore(3);
            int count = 0;

            public void run() {
                int time = rand.nextInt(15);
                int num = count++;

                try {
                    available.acquire();

                    System.out.println("Executing " + "long-running action for " + time + " seconds... #" + num);
                    Thread.sleep(time * 1000);
                    System.out.println("Done with #" + num + "!");
                    available.release();
                } catch (InterruptedException intEx) {
                    intEx.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++)
            new Thread(limitedCall).start();
    }
}