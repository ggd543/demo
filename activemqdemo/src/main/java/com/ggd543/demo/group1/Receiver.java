/*
 * @(#) Receiver.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-26
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo.group1;

/**
 * @author liuyongjian
 * @version 1.0
 */

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver {
    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的会话
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;

        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 创建会话
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(Constants.QUEUE_NAME);
            System.out.println(destination);
            consumer = session.createConsumer(destination);
            while (true) {
                //设置接收者接收消息的时间，为了便于测试，这里谁定为100s
                TextMessage message = (TextMessage) consumer.receive(1000);

                if (null != message) {
                    System.out.println("收到消息" + message.getText());
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (Throwable ignore) {
            }
        }
    }
}