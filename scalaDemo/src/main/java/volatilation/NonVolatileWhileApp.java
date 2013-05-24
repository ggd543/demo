/*
 * @(#) NonVolatileWhileApp.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-06
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package volatilation;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class NonVolatileWhileApp {

    public static void main(String[] args) throws InterruptedException {
        MyTaskThread mtt= new MyTaskThread();
        mtt.start();
        Thread.sleep(1000L);
        mtt.shutdown();
    }
}

class MyTaskThread extends Thread{
//    private static  boolean isStop = false;
    private  boolean isStop = false;

    public void shutdown(){
        isStop = true;
    }

    public void run(){
        while(!isStop){
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        System.out.println("MyTaskThread terminated");
    }
}
