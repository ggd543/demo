/*
 * @(#) ReceiveAttachment.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 13-4-9
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.javamail;


import com.germinus.easyconf.ComponentProperties;
import com.germinus.easyconf.EasyConf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.*;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class MailReceiver {

    //解析邮件内容
    private static void extractPart(final Part part) throws MessagingException, IOException {
        Object content = part.getContent();
        if (content instanceof Multipart) {
            Multipart mp = (Multipart) part.getContent();
            System.out.println(mp.getContentType() + " - " + mp.getCount());
            for (int i = 0; i < mp.getCount(); i++) {
                extractPart(mp.getBodyPart(i));
            }
        } else {
            System.out.println("~~~~~");
            System.out.println("contentType: " + part.getContentType());
            System.out.println("content: " + part.getContent());
            System.out.println("linecount: " + part.getLineCount());
            System.out.println("description: " + part.getDescription());
            System.out.println("disposition: " + part.getDisposition());
            System.out.println("fileName: " + part.getFileName());

            System.out.println("~~~~~~~");
        }
    }

    private static Properties prepareProperties(String protocol) {
        ComponentProperties mailProps = EasyConf.getConfiguration(protocol).getProperties();
        mailProps.setProperty("mail.store.protocol", "pop3");
        if (!mailProps.getBoolean("mail.pop3.socks.enable")) {
            mailProps.setProperty("mail.pop3.socks.host", "");
            mailProps.setProperty("mail.pop3.socks.port", "");
        }
        if (mailProps.getBoolean("mail.pop3.ssl.enable")) {
            int sslPort = mailProps.getInt("mail.pop3.ssl.port");
            if (sslPort == 0) {
                sslPort = mailProps.getInt("mail.pop3.port");
            }
            mailProps.setProperty("mail.pop3.port", "" + sslPort);
        }
        return mailProps.getProperties();
    }

    public static void main(String[] args) {
        String protocol = "pop3";
        Properties props = prepareProperties(protocol);
//        Authenticator authenticator = new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("test1@localhost.net", "test1");
//            }
//        };
//        Session session = Session.getInstance(props, authenticator);
        Session session = Session.getInstance(props);
        try {
//            Store store = session.getStore(protocol);
            Store store = session.getStore();
//            store.connect(mailServer, port, mailUserName, mailPassword);
            store.connect("test1@localhost.net", "test1");
//            store.connect("test_lyj@163.com", "abc123");
            Folder folder = store.getFolder("inbox");
            folder.open(Folder.READ_WRITE); // 允许读写
//            folder.open(Folder.READ_ONLY);  // 只允许读

            System.out.println("You have " + folder.getMessageCount() + " messages in inbox");
            System.out.println("You hava " + folder.getUnreadMessageCount() + " unread messages in inbox");
            Message[] msgs = folder.getMessages();

            for (int i = 0; i < msgs.length; i++) {
                Message message = msgs[i];
                System.out.println();
                System.out.println("====================================================================");
                printAddress(message.getFrom(), "from");
                printAddress(message.getRecipients(Message.RecipientType.TO), "to");
                printAddress(message.getRecipients(Message.RecipientType.BCC), "bcc");
                printAddress(message.getRecipients(Message.RecipientType.CC), "cc");
                message.setFlag(Flags.Flag.DELETED, true);
                System.out.println("====================================================================");
            }
            folder.close(true); //false：不删除标记为DELETED的邮件
            store.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printAddress(Address[] addresses, String type) {
        System.out.println(type + ": ");
        for (Address addr : addresses) {
            System.out.println(addr.toString());
        }
    }
}