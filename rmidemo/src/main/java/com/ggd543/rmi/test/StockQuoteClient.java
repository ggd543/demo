package com.ggd543.rmi.test;

import com.ggd543.rmi.StockQuote;
import com.ggd543.rmi.StockQuoteRegistry;
import com.ggd543.rmi.impl.StockQuoteImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */
public class StockQuoteClient {
    public static void main(String[] args) throws Exception, RemoteException {
        String url = "rmi://localhost";
        Context context = new InitialContext();
        final StockQuoteRegistry stockQuoteRegistry = (StockQuoteRegistry) context.lookup(url+"/StockQuoteRegistry");
        final StockQuoteImpl client = new StockQuoteImpl();
        stockQuoteRegistry.registerClient(client);
        new Thread(){
            public void run(){
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }finally{
                    try {
                        stockQuoteRegistry.unregister(client);
                    } catch (Exception e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }.start();
    }
}
