package com.ggd543.rmi.test;

import com.ggd543.rmi.StockQuoteRegistry;
import com.ggd543.rmi.impl.StockQuoteRegistryImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class StockQuoteServer {
    public static void main(String[] args) throws RemoteException, NamingException {
        StockQuoteRegistryImpl stockQuoteRegistry = new StockQuoteRegistryImpl();
        Context context = new InitialContext();
        context.rebind("rmi:StockQuoteRegistry",stockQuoteRegistry);
        System.out.println("服务器注册了一个StockQuoteRegistry对象");
        new Thread(stockQuoteRegistry).start();
    }
}
