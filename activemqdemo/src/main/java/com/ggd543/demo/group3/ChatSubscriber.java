package com.ggd543.demo.group3;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.memory.list.MessageList;

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
public class ChatSubscriber implements PubSub, MessageListener {
    private TopicSession session;
    private TopicSubscriber sub;
    private TopicConnection conn;
    private String name;

    public ChatSubscriber(String name, String topicName, boolean isDurable, String clientId) throws JMSException {
        this.name = name;
        TopicConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        conn = factory.createTopicConnection();
        conn.setClientID(clientId);
        session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = new ActiveMQTopic(topicName);

        if (isDurable) {
            sub = session.createDurableSubscriber(topic, clientId + "_");
            System.out.println("...");
        } else {
            sub = session.createSubscriber(topic);
        }
        sub.setMessageListener(this);
    }

    public void start() {
        try {
            conn.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("[name=" + name + "]" + message);
    }

    public static void main(String[] args) {
        try {
            ChatSubscriber chatSubscriber = new ChatSubscriber(args[0], args[1], Boolean.valueOf(args[2]), args[3]);
            chatSubscriber.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
