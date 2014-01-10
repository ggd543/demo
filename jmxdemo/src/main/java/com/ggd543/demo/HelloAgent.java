package com.ggd543.demo;

import javax.management.*;

import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 * 功能描述：
 * <p> 版权所有：优视科技
 * <p> 未经本公司许可，不得以任何方式复制或使用本程序任何部分 <p>
 *
 * @author <a href="mailto:liuyj3@ucweb.com">刘永健</a>
 * @version 1.0.0
 * @since 1.0.0
 * create on: 2014年01月06
 */
public class HelloAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName helloName = new ObjectName("archer:name=helloworld");
        server.registerMBean(new Hello(), helloName);
        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladaptor,port=8045");
        HtmlAdaptorServer adaptorServer = new HtmlAdaptorServer(8045);
        server.registerMBean(adaptorServer, adapterName);
        adaptorServer.start();
        System.out.println("start .. ");
    }
}
