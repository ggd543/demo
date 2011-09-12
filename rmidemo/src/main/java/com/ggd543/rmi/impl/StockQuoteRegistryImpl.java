package com.ggd543.rmi.impl;

import com.ggd543.rmi.StockQuote;
import com.ggd543.rmi.StockQuoteRegistry;
import com.ggd543.rmi.test.StockQuoteClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-12
 * Time: 下午2:19
 * To change this template use File | Settings | File Templates.
 */
public class StockQuoteRegistryImpl implements StockQuoteRegistry, Runnable {
    public StockQuoteRegistryImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void run() {
        //创建一些股票代号
        String[] symbols = new String[]{"SUNW", "MSFT", "DAL", "WUTK", "SAMY", "KATY"};
        Random random = new Random();
        double[] values = new double[symbols.length];

        //为每个股票分配任意价格
        for (int i = 0; i < values.length; i++) {
            values[i] = 25.0 + random.nextInt(100);
        }

        for (; ;) {
            //随机取出一个股票
            int sym = random.nextInt(symbols.length);
            //修改股票的价格
            int change = 100 - random.nextInt(201);
            values[sym] = values[sym] + ((double) change) / 100.0;
            if (values[sym] < 0) values[sym] = 0.01;

            synchronized (clientsLock) {
                Iterator<StockQuote> iter = clients.iterator();
                while (iter.hasNext()) {
                    StockQuote client = iter.next();
                    try {
                            client.quote(symbols[sym], values[sym]);
                    } catch (Exception e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        iter.remove();
                    }
                }

            }

            try {
                System.out.println("Pause 1s ...");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }//for
    }

    private HashSet<StockQuote> clients = new HashSet<StockQuote>();
    private byte[] clientsLock = new byte[0];

    @Override
    public void registerClient(StockQuote client) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
        System.out.println(Thread.currentThread()+" 加入一个客户: " + client);
        synchronized (clientsLock) {
            clients.add(client);
        }
    }

    @Override
    public void unregister(StockQuote client) throws Exception {
        System.out.println(Thread.currentThread()+" 删除一个客户: " + client);
        synchronized (clientsLock) {
            clients.remove(client);
        }
    }
}
