package com.ggd543.demo.virtualtopic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import scala.tools.nsc.symtab.StdNames;

import javax.jms.*;

/**
 * Created by ggd543 on 14-1-12.
 */
public class Producer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(TestVirtualTopic.URL);
        Topic topic = new ActiveMQTopic(TestVirtualTopic.getVirtualTopicName());
        ActiveMQConnection conn = (ActiveMQConnection) factory.createConnection();
        Session session = conn.createTopicSession(true, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        conn.start();
        int index = 0;
        while (index++ < 5) {
            TextMessage message = session.createTextMessage(index + " message.");
            System.out.println(message);
            producer.send(message);
        }
        session.commit();
//        session.rollback();
        session.close();
        conn.close();
    }


}
