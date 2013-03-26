/*
 * @(#) Main.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-26
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo.group2;

/**
 * @author liuyongjian
 * @version 1.0
 */

import javax.jms.JMSException;


public class Main {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyMessageProducer sender = new MyMessageProducer();
        MyMessageConsumer consumer = new MyMessageConsumer("zhc");
        String url = "tcp://localhost:10000",queue="zhc.queue";
        try {
            Server.startServer();
            sender.product(url,queue);
            consumer.revice(url,queue);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
