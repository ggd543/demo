package com.ggd543.rmi;

import java.rmi.Remote;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午2:18
 * To change this template use File | Settings | File Templates.
 */
public interface StockQuoteRegistry extends Remote{
    public void registerClient(StockQuote client) throws Exception;
    public void unregister(StockQuote client) throws Exception;
}
