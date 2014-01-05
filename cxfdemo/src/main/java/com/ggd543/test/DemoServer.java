package com.ggd543.test;

import com.ggd543.webservice.HelloWorldImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-10-5
 * Time: 下午7:21
 * To change this template use File | Settings | File Templates.
 */
public class DemoServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloWorldImpl.class);
        factory.setAddress("http://localhost:7070/helloWorld");
        Server server = factory.create();
        server.start();
    }
}
