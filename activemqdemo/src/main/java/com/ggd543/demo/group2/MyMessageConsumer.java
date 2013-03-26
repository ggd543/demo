/*
 * @(#) MyMessageConsumer.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-26
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo.group2;

/**
 * @author liuyongjian
 * @version 1.0
 */

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MyMessageConsumer {
    private String name;

    public MyMessageConsumer(String name) {
        this.name = name;
    }

    public void revice(String url, String queue) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(null, null, url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true,
                Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(queue);
        MessageConsumer consumer = session.createConsumer(destination);
        while (true) {
            System.out.println(name + "------等待消息------");
            Message msg = consumer.receive(1000);
            TextMessage message = (TextMessage) msg;
            if (null != message) {
                System.out.println("收到消息:" + message.getText());
            }
        }
    }

}