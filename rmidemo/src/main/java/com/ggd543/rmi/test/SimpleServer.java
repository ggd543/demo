package com.ggd543.rmi.test;

import com.ggd543.rmi.HelloService;
import com.ggd543.rmi.IB;
import com.ggd543.rmi.impl.FlightFactoryImpl;
import com.ggd543.rmi.impl.HelloServiceImpl;
import com.ggd543.rmi.impl.IBImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午1:19
 * To change this template use File | Settings | File Templates.
 */
public class SimpleServer {
    public static void main(String[] args) throws RemoteException, NamingException {
        System.setProperty("java.rmi.dgc.leaseValue", "3000");
        System.out.println("java.rmi.server.codebase: " + System.getProperty("java.rmi.server.codebase"));
        
        HelloService hs1 = new HelloServiceImpl("HelloService");
        IB ib = new IBImpl("IB");
        Context context = new InitialContext();
        context.rebind("rmi:HelloService", hs1);
        context.rebind("rmi:IB", ib);
        context.rebind("rmi:FlightFactory", new FlightFactoryImpl());
        System.out.println("服务器注册了三个Remote Object");

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            context.unbind("rmi:HelloService");
            context.unbind("rmi:IB");
            context.unbind("rmi:FlightFactory");
            System.out.println("服务器注销了三个Remote Object");
        }

    }


}
