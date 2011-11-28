package com.ggd543.rmi.test;

import com.ggd543.rmi.Flight;
import com.ggd543.rmi.FlightFactory;
import com.ggd543.rmi.HelloService;
import com.ggd543.rmi.IB;

import javax.naming.*;
import java.io.IOException;
import java.net.URL;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午1:28
 * To change this template use File | Settings | File Templates.
 */
public class SimpleClient {
    public static void main(String[] args) throws Exception, IOException {
        System.out.println("java.rmi.server.codebase: " + System.getProperty("java.rmi.server.codebase"));
        URL policyUrl = SimpleClient.class.getResource("/client.policy");
        System.out.println(policyUrl);
        System.setProperty("java.security.policy", policyUrl.toString());
        System.setSecurityManager(new RMISecurityManager());
        
        String url = "rmi://localhost:1099";
        Context context = new InitialContext();
        //列出所有远程对象
        showRemoteObjects(context);
        //获取存根对象
        HelloService hs = (HelloService) context.lookup(url + "/HelloService");
        IB ib = (IB) context.lookup(url + "/IB");
        //测试存根对象所属的类
        Class stubClass = hs.getClass();
        System.out.println("hs 是" + stubClass.getName() + " 的实例");
        Class[] interfaces = stubClass.getInterfaces();
        for (Class c : interfaces) {
            System.out.println("HelloService的存根类实现了:　" + c.getName());
        }

        System.out.println(hs.echo("Jack"));
        System.out.println(hs.getTime());

        System.out.println(ib.getEcho("Tom"));
        System.out.println(ib.getDate());

        FlightFactory flightFactory = (FlightFactory) context.lookup(url + "/FlightFactory");
        FlightFactory flightFactory2 = (FlightFactory) context.lookup(url + "/FlightFactory");
        System.out.println("flightFac" +
                "tory == flightFactory2 "+(flightFactory == flightFactory2)); //false
        System.out.println("flightFactory equals flightFactory2 "+(flightFactory.equals(flightFactory2))); // true
        
        Flight flight1 = flightFactory.getFlight("793");
        Flight flight2 = flightFactory.getFlight("793");
        System.out.println("flight1 == flight2 "+(flight1 == flight2)); //false
        System.out.println("flight1 equals flight2 "+(flight1.equals(flight2)));

        flight1.setDestCity("CAN");
        flight1.setOriginCity("PEK");
        flight1.setFlightDate(new Date());

        System.out.println(flight2.toString()); // Proxy ...
        System.out.println("destCity: "+flight2.getDestCity()+" originCity: "+flight2.getOriginCity());
    }

    public static void showRemoteObjects(Context context) throws NamingException {
        NamingEnumeration<NameClassPair> e = context.list("rmi:");
        while (e.hasMore()) {
            NameClassPair ncp = e.next();
            System.out.println("name: " + ncp.getName() + " className: " + ncp.getClassName());
        }
    }
}
