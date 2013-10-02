package com.ggd543.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-10
 * Time: 下午11:03
 * To change this template use File | Settings | File Templates.
 */
public class ReentrantLockTester {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();

    public static void main(String[] args) {
       //TODO
    }
}
