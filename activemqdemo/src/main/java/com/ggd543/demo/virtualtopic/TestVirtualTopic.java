package com.ggd543.demo.virtualtopic;

/**
 * 功能描述：
 * <p> 版权所有：优视科技
 * <p> 未经本公司许可，不得以任何方式复制或使用本程序任何部分 <p>
 *
 * @author <a href="mailto:liuyj3@ucweb.com">刘永健</a>
 * @version 1.0.0
 * @since 1.0.0
 * create on: 2014年01月10
 */

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;



public class TestVirtualTopic {
    public static String URL ="tcp://127.0.0.1:61616";

    public static void main(String[] args) {
        try {
            ActiveMQConnectionFactory factoryA = new ActiveMQConnectionFactory();
            Queue queue = new ActiveMQQueue(getVirtualTopicConsumerNameA());
            ActiveMQConnection conn = (ActiveMQConnection) factoryA.createConnection();
            conn.start();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer1 = session.createConsumer(queue);
            MessageConsumer consumer2 = session.createConsumer(queue);
            System.out.println(consumer1);
            System.out.println(consumer2);
            MessageConsumer consumer3 = session.createConsumer(new ActiveMQQueue(getVirtualTopicConsumerNameB()));

            final AtomicInteger aint1 = new AtomicInteger(0);

            MessageListener listenerA = new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println(aint1.incrementAndGet() + " => receive from " + getVirtualTopicConsumerNameA() + ": " + message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            consumer1.setMessageListener(listenerA);
            consumer2.setMessageListener(listenerA);

            final AtomicInteger aint2 = new AtomicInteger(0);
            MessageListener listenerB = new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println(aint2.incrementAndGet() + " => receive from " + getVirtualTopicConsumerNameB() + ": " + message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            consumer3.setMessageListener(listenerB);

            MessageProducer producer = session.createProducer(new ActiveMQTopic(getVirtualTopicName()));
            int index = 0;
            while (index++ < 5) {
                TextMessage message = session.createTextMessage(index + " message.");
                producer.send(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getTopicName() {
        return "Topic.TEST";

    }

    public static String getVirtualTopicName() {
        return "VirtualTopic.TEST";
    }

    public static String getVirtualTopicConsumerNameA() {
        return "Consumer.A.VirtualTopic.TEST";
    }

    public static String getVirtualTopicConsumerNameB() {
        return "Consumer.B.VirtualTopic.TEST";
    }

}