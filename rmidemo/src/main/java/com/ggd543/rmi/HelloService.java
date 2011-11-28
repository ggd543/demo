package com.ggd543.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午12:58
 * To change this template use File | Settings | File Templates.
 */
public interface HelloService extends  Remote {
    public String echo(String msg) throws RemoteException;
    
    public Date getTime() throws RemoteException;

    public boolean isAccessed() throws RemoteException;

    public void access() throws RemoteException;

    public void bye() throws RemoteException;
    
}

