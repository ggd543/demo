package com.ggd543.demo.virtualtopic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * Created by ggd543 on 14-1-12.
 */
public class Publisher {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(TestVirtualTopic.URL);
        TopicConnection conn =  factory.createTopicConnection();
//        Topic topic = new ActiveMQTopic(TestVirtualTopic.getTopicName());
        Topic topic = new ActiveMQTopic(TestVirtualTopic.getVirtualTopicName());
        TopicSession session = conn.createTopicSession(true, Session.AUTO_ACKNOWLEDGE);
        TopicPublisher pub = session.createPublisher(topic);
        pub.setDeliveryMode(DeliveryMode.PERSISTENT);
        conn.start();
        int index = 0;
        while (index++ < 5) {
            TextMessage message = session.createTextMessage(index + " message.");
            System.out.println(message);
//            producer.send(message);
            pub.send(message);
        }
        session.commit();
//        session.rollback();
        session.close();
        conn.close();

    }
}
