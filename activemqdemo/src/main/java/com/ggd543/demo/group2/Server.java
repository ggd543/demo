/*
 * @(#) Server.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-26
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo.group2;

/**
 * @author liuyongjian
 * @version 1.0
 */
import org.apache.activemq.broker.BrokerService;
public class Server{
    public static void startServer() {
        BrokerService service = new BrokerService();
        try {
            service.addConnector("tcp://localhost:10000");
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}