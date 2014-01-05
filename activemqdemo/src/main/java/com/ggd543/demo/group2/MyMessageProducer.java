/*
 * @(#) MyMessageProducer.java
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
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MyMessageProducer{
    public void product(String url,String queue) throws JMSException {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(null,null, url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true,   Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queue);
            MessageProducer producer = session.createProducer(destination);
            sendMsg(session, producer);
            session.commit();
            connection.close();
        } finally {
            System.out.println("-----发送完毕！");
        }
    }

    private void sendMsg(Session session, MessageProducer producer)
            throws JMSException {
        for (int i = 1; i <= 5; i++) {
            TextMessage message = session.createTextMessage("学习ActiveMq 发送的消息"
                    + i);
            producer.send(message);
        }
    }
}
