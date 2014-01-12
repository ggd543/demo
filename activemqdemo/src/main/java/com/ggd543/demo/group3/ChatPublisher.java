package com.ggd543.demo.group3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.memory.list.MessageList;
import sun.misc.IOUtils;

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
public class ChatPublisher  implements  PubSub , MessageListener{
    private TopicSession session;
    private TopicPublisher pub;
    private TopicConnection conn;
    private String name;

    public ChatPublisher(String name, String topicName, boolean isDurable) throws JMSException {
        this.name = name ;
        TopicConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        conn = factory.createTopicConnection();
        session = conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        pub = session.createPublisher(new ActiveMQTopic(topicName));

        if (isDurable) {
            pub.setDeliveryMode(DeliveryMode.PERSISTENT);
//            pub.setTimeToLive(20000);
            System.out.println("persistence");
        }
    }

    public void start()  {
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
        System.out.println("[name="+name+"]"+message);
    }

    public static void main(String[] args) {
        try {
            ChatPublisher publisher = new ChatPublisher(args[0], args[1], Boolean.valueOf(args[2]));
            publisher.start();
            BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String s = cmd.readLine();

                if (s.equalsIgnoreCase("exit")) {
                    publisher.stop();
                    System.exit(0);
                }else{
                    publisher.writeMessage(s);
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeMessage(String s) throws JMSException {

        TextMessage message = session.createTextMessage();
        message.setStringProperty("language", "java");
        message.setText(s);
        System.out.println("sending text message " + message);
        pub.publish(message);
    }
}
