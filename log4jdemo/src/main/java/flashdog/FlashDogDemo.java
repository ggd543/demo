/*
 * @(#) FlashDogDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-13
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package flashdog;

import java.net.URL;
import java.util.Random;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class FlashDogDemo {
    private static Logger logger;

    static {
        URL log4jPropUrl = FlashDogDemo.class.getResource("log4j.properties");
        System.out.println(log4jPropUrl);
        PropertyConfigurator.configure(log4jPropUrl);
        logger = Logger.getLogger(FlashDogDemo.class);
    }

    public static void main(String[] args) {
        int maxInterval = 3;
        int countOfThread = 5;
        if (args.length > 0) {
            countOfThread = Integer.parseInt(args[0]);
        } else if (args.length > 1) {
            maxInterval = Integer.parseInt(args[1]);
        }
        System.out.println(maxInterval+" "+countOfThread);
//        System.exit(1);
        for (int i = 0; i < countOfThread; i++) {
            new LogThread(maxInterval).start();
        }

    }

    private static class LogThread extends Thread {
        private int maxInterval;


        public LogThread(int maxInterval) {
            this.maxInterval = maxInterval;
        }

        public void run() {
            final Random rnd = new Random();
            while (true) {
                log(rnd);
                pause(rnd, maxInterval);
            }
        }

        private final Level[] LEVELS = {Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR, Level.FATAL};

        private final String[] MSG = {
                "---------------------------------------- debug message -----------------------------------",
                "==================================== hello world =========================================",
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Attention please ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~",
                "java.lang.RuntimeException\n" +
                        "        at .<init>(<console>:8)\n" +
                        "        at .<clinit>(<console>)\n" +
                        "        at .<init>(<console>:11)\n" +
                        "        at .<clinit>(<console>)\n" +
                        "        at $print(<console>)\n" +
                        "        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
                        "        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)\n" +
                        "        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)\n" +
                        "        at java.lang.reflect.Method.invoke(Method.java:597)\n" +
                        "        at scala.tools.nsc.interpreter.IMain$ReadEvalPrint.call(IMain.scala:704)\n" +
                        "        at scala.tools.nsc.interpreter.IMain$Request$$anonfun$14.apply(IMain.scala:920)\n" +
                        "        at scala.tools.nsc.interpreter.Line$$anonfun$1.apply$mcV$sp(Line.scala:43)\n" +
                        "        at scala.tools.nsc.io.package$$anon$2.run(package.scala:25)\n" +
                        "        at java.lang.Thread.run(Thread.java:662)",
                "#################################### A Fatal Error ####################################"};

        private void log(Random rnd) {
            int rndLevel = rnd.nextInt(5);
            logger.log(LEVELS[rndLevel], MSG[rndLevel]);
        }

        private void pause(Random rnd, int maxInterval) {
            int rndSecond = rnd.nextInt(3);
            try {
                Thread.sleep(1000L * rndSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }


}
