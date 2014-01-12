package com.ggd543.demo.virtualtopic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * Created by ggd543 on 14-1-12.
 */
public class Subscriber  {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(TestVirtualTopic.URL);
        TopicConnection conn =   factory.createTopicConnection();
//        String clientId = System.currentTimeMillis() +"_"+ Math.random();
        String clientId = args[0];
        System.out.println("ClientId: "+clientId);
        conn.setClientID(clientId);
        TopicSession session = conn.createTopicSession(false,  Session.AUTO_ACKNOWLEDGE);
//        Topic topic = new ActiveMQTopic(TestVirtualTopic.getTopicName());
        Topic topic = new ActiveMQTopic(TestVirtualTopic.getVirtualTopicName());
//        Topic topic = new ActiveMQTopic("test1");
        TopicSubscriber sub = session.createDurableSubscriber(topic, clientId+"_");
        sub.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println(message);
            }
        });
        conn.start();
    }

}
