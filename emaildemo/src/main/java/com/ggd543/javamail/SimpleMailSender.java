/*
 * @(#) SimpleMailSender.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 13-4-9
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.javamail;

import com.germinus.easyconf.ComponentProperties;
import com.germinus.easyconf.EasyConf;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class SimpleMailSender {
    private static void test1(){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.append("i want to go home\n");
        pw.append("i love you");
        pw.flush();
        pw.close();
        System.out.println(sw);
    }

    private static void test2(){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            throw new RuntimeException("fuxk");
        }catch (RuntimeException e){
            e.printStackTrace(pw);
        }finally {
            pw.flush();
            pw.close();
        }
        System.out.println();
        System.out.println(sw.toString());
    }


    private static Properties prepareProperties(String protocol) {
        ComponentProperties mailProps = EasyConf.getConfiguration(protocol).getProperties();
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
//      test1();
//        test2();
        String protocol = "smtp";
        try {
            // 创建 properties ，里面包含了发送邮件服务器的地址。
            Properties mailProps = prepareProperties(protocol);
            // 创建 session
            Session mailSession = Session.getInstance(mailProps);

            // 创建 邮件的message，message对象包含了邮件众多有的部件，都是封装成了set方法去设置的
            MimeMessage message = new MimeMessage(mailSession);

            //设置发信人
            message.setFrom(new InternetAddress("test1@localhost.net"));

            //收信人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("test1@localhost.net"));
            message.setRecipient(Message.RecipientType.CC, new InternetAddress("test1@localhost.net"));
            message.setRecipient(Message.RecipientType.BCC, new InternetAddress("test1@localhost.net"));

            // 邮件标题
            message.setSubject("a poem");
            message.setText("i love you");
            Transport transport = mailSession.getTransport();
            transport.connect("test1@localhost.net", "test1");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
