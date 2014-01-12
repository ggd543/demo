package com.ggd543.demo.group1;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

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
public class MultipleConnReceiver implements MessageListener, Runnable {

    @Override
    public void run() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        Queue queue = new ActiveMQQueue(Constants.QUEUE_NAME);
        Connection conn = null;
        try {
            conn = factory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(this);
            System.out.println(consumer);
            System.out.println(this);
            conn.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(this + " receive " + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MultipleConnReceiver());
        Thread t2 = new Thread(new MultipleConnReceiver());
        t1.start();
        t2.start();
    }
}
