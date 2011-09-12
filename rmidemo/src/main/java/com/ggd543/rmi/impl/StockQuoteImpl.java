package com.ggd543.rmi.impl;

import com.ggd543.rmi.StockQuote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 */
public class StockQuoteImpl implements StockQuote{
    
    public StockQuoteImpl() throws RemoteException{
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public void quote(String stockSymbol, double price) throws RemoteException {
        System.out.println(stockSymbol+" : "+price);
    }

    public void doublePrice(String stockSymbol, double price) {
        System.out.println(stockSymbol+" : "+2*price+" double price");
    }
}
