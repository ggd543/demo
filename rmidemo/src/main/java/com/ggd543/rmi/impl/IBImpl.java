package com.ggd543.rmi.impl;

import com.ggd543.rmi.IB;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午1:17
 * To change this template use File | Settings | File Templates.
 */
public class IBImpl implements IB {
    final private String name;
    
    public IBImpl(String name) throws RemoteException {
        this.name = name;
        UnicastRemoteObject.exportObject((Remote)this, 0);
    }
    
    public String getEcho(String msg) throws IOException {
        System.out.println("IB.getEcho " + msg);
        return msg;
    }

    public Date getDate() throws Exception {
        Date d = new Date();
        System.out.println("Now is " + d);
        return d;
    }
}

