package com.ggd543.demo.group3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQTopic;

public class Chat implements MessageListener {
    private TopicSession pubSession;
    private TopicPublisher pub;
    private TopicConnection conn;
    private String msgType;

    public Chat(String clientId, String topicName, String msgType)
            throws NamingException, JMSException {

        // lookup a topic connection factory
//        TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup(topicFactory);
        TopicConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        // create a topic connection
        try {
            TopicConnection connection = factory.createTopicConnection();

            // create two jms session;
            TopicSession pubSession = (TopicSession) connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);
            TopicSession subSession = (TopicSession) connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = new ActiveMQTopic(topicName);

            // create publisher and subscriber
            TopicPublisher pub = pubSession.createPublisher(topic);
            TopicSubscriber sub = subSession.createSubscriber(topic, null, true);

            if (clientId != null) {
                pub.setDeliveryMode(DeliveryMode.PERSISTENT);
                pub.setTimeToLive(20000);
                connection.setClientID(clientId);
                sub = subSession.createDurableSubscriber(topic, clientId+"_");
            }

            System.out.println("topic: " + topic);
            System.out.println("pub: " + pub);
            System.out.println("sub: " + sub);
            // set a jms listener
            sub.setMessageListener(this);

            this.conn = connection;
            this.pub = pub;
            this.pubSession = pubSession;
            this.msgType = msgType;

            // this is necessary
            connection.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void writeMessage(String txt) {
        if (this.msgType.equalsIgnoreCase("txt")) {
            writeTextMessage(txt);
        }
        if (this.msgType.equalsIgnoreCase("byte")) {
            writeByteMessage(txt);
        }
    }

    private void writeTextMessage(String txt) {
        try {
            String msg = txt;

            String iso = new String(txt.getBytes("GBK"), "ISO-8859-1");

            TextMessage message = pubSession.createTextMessage();
            message.setStringProperty("language", "java");
            message.setText(iso);
            System.out.println("sending text message " + message);
            pub.publish(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void writeByteMessage(String txt) {
        try {
            String msg = txt;

            BytesMessage message = pubSession.createBytesMessage();
            byte[] data = msg.getBytes();
            System.out.println("sent data len:" + data.length);
            System.out.println("send bytes:");
            console(data);
            message.setStringProperty("language", "java");
            message.writeBytes(data);
            pub.publish(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public void onMessage(Message msg) {
        if (msg instanceof BytesMessage) {
            BytesMessage message = (BytesMessage) msg;

            try {
                onBytesMessage(message);

            } catch (JMSException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if (msg instanceof TextMessage) {

            TextMessage message = (TextMessage) msg;

            try {
                onTextMessage(message);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        if (msg instanceof ActiveMQMessage) {
            System.out.println("\nthis is a ActiveMQMessage...");

            ActiveMQMessage message = (ActiveMQMessage) msg;
            System.out.println(message);
        }
    }

    private void onBytesMessage(BytesMessage message) throws JMSException,
            UnsupportedEncodingException {
        long len = message.getBodyLength();
        System.out.println("body len: " + len);

        byte[] arr = new byte[(int) len];
        message.readBytes(arr);

        System.out.print("get bytes:");
        console(arr);
        String txt = new String(arr, "GBK");
        System.out.println(txt);
    }

    private void onTextMessage(TextMessage message) throws JMSException {
        String txt = message.getText();

        try {
            String gbk = new String(txt.getBytes("ISO-8859-1"), "GBK");
            System.out.println(gbk);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void close() throws JMSException {
        this.conn.close();
    }

    public static void main(String[] args) throws NamingException,
            JMSException, IOException {
//        if (args.length != 4) {
//            System.out.println("Factory, Topic, or username missing");
//        }
        // topicFactory, topicName, clientId,  msgType
        Chat chat = new Chat(args[0], "test", "txt");

        BufferedReader cmd = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String s = cmd.readLine();

                if (s.equalsIgnoreCase("exit")) {
                chat.close();
                System.exit(0);
            } else {
                chat.writeMessage(s);
            }
        }
    }


    public static void console(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print(b);
            System.out.print(",");
        }
        System.out.println("");
    }
}
