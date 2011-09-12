package com.ggd543.rmi.test;

import com.ggd543.rmi.HelloService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.URL;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
public class SetupClient {
    public static void main(String[] args) throws NamingException, RemoteException {
         System.out.println("java.rmi.server.codebase: " + System.getProperty("java.rmi.server.codebase"));

        String url = "rmi://localhost:1099";
        Context context = new InitialContext();
        //获取存根对象
        HelloService hs = (HelloService) context.lookup(url + "/HelloService");
        String str = hs.echo("Jack");
        System.out.println(str);
    }
}
