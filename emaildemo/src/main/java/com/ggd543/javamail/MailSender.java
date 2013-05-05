/*
 * @(#) SendAttachment.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 13-4-8
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.javamail;

/**
 * @author liuyongjian
 * @version 1.0
 */

import com.germinus.easyconf.ComponentProperties;
import com.germinus.easyconf.EasyConf;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.util.ByteArrayDataSource;

public class MailSender {

    private static Properties prepareProperties(String protocol) {
        ComponentProperties mailProps =EasyConf.getConfiguration(protocol).getProperties();
        mailProps.setProperty("mail.transport.protocol","smtp");
        if (!mailProps.getBoolean("mail.smtp.socks.enable")) {
            mailProps.setProperty("mail.smtp.socks.host", "");
            mailProps.setProperty("mail.smtp.socks.port", "");
        }
        if (mailProps.getBoolean("mail.smtp.ssl.enable")) {
            int sslPort = mailProps.getInt("mail.smtp.ssl.port");
            if (sslPort == 0) {
                sslPort = mailProps.getInt("mail.smtp.port");
            }
            mailProps.setProperty("mail.smtp.port", ""+sslPort);
        }
        return  mailProps.getProperties();
    }

    public static void main(String[] args) {
        String protocol = "smtp";
        try {
            // 创建 properties ，里面包含了发送邮件服务器的地址。
            Properties mailProps = prepareProperties(protocol);

//            Authenticator authenticator = new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication("test1@localhost.net","test1");
////                    return new PasswordAuthentication("liuyongjian@travelsky.com","4phvjs");
////                    return new PasswordAuthentication("test_lyj@163.com", "abc123");
//                }
//
//            };

            // 创建 session
//            Session mailSession = Session.getInstance(mailProps, authenticator);
            Session mailSession = Session.getInstance(mailProps);

            // 创建 邮件的message，message对象包含了邮件众多有的部件，都是封装成了set方法去设置的
            MimeMessage message = new MimeMessage(mailSession);

            //设置发信人
            message.setFrom(new InternetAddress("test1@localhost.net"));
//            message.setFrom(new InternetAddress("liuyongjian@travelsky.com"));
//            message.setFrom(new InternetAddress("test_lyj@163.com"));

            //收信人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("test1@localhost.net"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("test_lyj@163.com"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("liuyongjian@travelsky.com"));

            // 邮件标题
            message.setSubject("a poem");

            //主要作用是将以后创建的n个内容加入MimeMultipart
            MimeMultipart multi = new MimeMultipart();

            // 创建第二个BodyPart,是一个FileDataSource
            URL url = MailSender.class.getResource("/key.txt");
            FileDataSource fds = new FileDataSource(new File(url.getPath()));
            BodyPart fileBodyPart = new MimeBodyPart();
            fileBodyPart.setDataHandler(new DataHandler(fds));   //字符流形式装入文件
            fileBodyPart.setFileName(fds.getName());        // 如果不设置文件名，可能会被当做正文
            multi.addBodyPart(fileBodyPart);

            URL url2 = MailSender.class.getResource("/C_chris.jpg");
            FileDataSource fds2 = new FileDataSource(new File(url2.getPath()));
            BodyPart fileBodyPart2 = new MimeBodyPart();
            fileBodyPart2.setDataHandler(new DataHandler(fds2));   //字符流形式装入文件
            fileBodyPart2.setFileName(fds2.getName());   // 如果不设置文件名，可能会被当做正文
            multi.addBodyPart(fileBodyPart2);

//            // 创建 BodyPart，主要写一些一般的信件内容。
//            BodyPart textBodyPart = new MimeBodyPart();
//            textBodyPart.setText("Do you fear the force of the wind The slash of the rain Go face them and fight them " +
//                    "Be savage again. Go hungry and cold like the wolf, Go wade like the crane: " +
//                    "The palms of your hands will thicken, The skin of your cheek will tan, You'll grow ragged and weary and swarthy, " +
//                    "But you'll walk like a man!");
//            //  添加到MimeMultipart容器中
//            multi.addBodyPart(textBodyPart);

            // 将MimeMultPart作为Content加入message
            message.setContent(multi);
//            message.setText();
            // 所有以上的工作必须保存
            message.saveChanges();

            // Transport.send()方法会自动调用message.saveChanges()方法
//            Transport.send(message);
            Transport transport = mailSession.getTransport(protocol);
//            transport.connect();
//            transport.connect("liuyongjian@travelsky.com","4phvjs");
            transport.connect("test1@localhost.net", "test1");
//            transport.connect("test_lyj@163.com", "abc123");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Mail send succesfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
