package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: 刘永健
 * Date: 12-10-17
 * Time: 上午12:37
 * To change this template use File | Settings | File Templates.
 */

class Task1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "Start task1");
        Object obj = new Object();
        synchronized (obj) {
            try {
                obj.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
        System.out.println(Thread.currentThread() + "Stop task1");
    }
}


class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "Start task2");
        System.out.println(Thread.currentThread() + "Stop task2");
    }
}

public class SleepWaitTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(new Task1());
        executor.submit(new Task2());
        executor.shutdown();
    }
}
