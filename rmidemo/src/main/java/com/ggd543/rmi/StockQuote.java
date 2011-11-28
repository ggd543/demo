package com.ggd543.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午2:13
 * To change this template use File | Settings | File Templates.
 */
public interface StockQuote extends Remote {
    public void quote(String stockSymbol, double price ) throws Exception;
}
