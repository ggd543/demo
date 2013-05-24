/*
 * @(#) StopThread.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-06
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package volatilation;

import java.util.concurrent.TimeUnit;

/**
 * 不一定能重重现《Effective Java》第10章第66条里面提到的那个例子所展示的现象
 * @author liuyongjian
 * @version 1.0
 */
public class StopThread {

    public static boolean stopRequest;

    public static void requestStop() {
        stopRequest = true;
    }

    public static boolean stopRequest() {
        return stopRequest;
    }
//
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable(){
            @Override
            public void run() {
                int i=0;
                while(!stopRequest()){
//                while(!stopRequest){
                    i++;
//                    try {
//                        Thread.sleep(1000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                    }
                }
            }
        });
//        Thread backgroundThread = new Thread(new FuxkTask());
//        Thread backgroundThread = new FuxkTask();
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
        System.out.println("stopRequest: "+stopRequest);
    }
}

//class FuxkTask implements Runnable{
//class FuxkTask extends Thread {
//    public static boolean stopRequest;
//
//    public static void requestStop() {
//        stopRequest = true;
//    }
//
//    public static boolean stopRequest() {
//        return stopRequest;
//    }
//
//    @Override
//    public void run() {
//        int i = 0;
//        while (!StopThread.stopRequest()) {
////                while(!stopRequest){
//            i++;
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }
//        }
//    }
//}