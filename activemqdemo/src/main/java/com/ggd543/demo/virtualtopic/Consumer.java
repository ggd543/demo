package com.ggd543.demo.virtualtopic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ggd543 on 14-1-12.
 */
public class Consumer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(TestVirtualTopic.URL);
        ActiveMQConnection conn = (ActiveMQConnection) factory.createConnection();
        String clientId = System.currentTimeMillis()+"";
        System.out.println("ClientId: "+clientId);
        conn.setClientID(clientId);
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = new ActiveMQQueue(TestVirtualTopic.getVirtualTopicConsumerNameA());
        MessageConsumer consumer1 = session.createConsumer(queue);
        MessageConsumer consumer2 = session.createConsumer(queue);
        MessageConsumer consumer3 = session.createConsumer(new ActiveMQQueue(TestVirtualTopic.getVirtualTopicConsumerNameB()));

        final AtomicInteger aint1 = new AtomicInteger(0);

        MessageListener listenerA = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    System.out.println(aint1.incrementAndGet() + " => receive from "
                            + TestVirtualTopic.getVirtualTopicConsumerNameA() + ": " + message);
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
                    System.out.println(aint2.incrementAndGet() + " => receive from "
                            + TestVirtualTopic.getVirtualTopicConsumerNameB() + ": " + message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        consumer3.setMessageListener(listenerB);

        System.out.println(consumer1);
        System.out.println(consumer2);
        System.out.println(consumer3);

        conn.start();
    }
}
