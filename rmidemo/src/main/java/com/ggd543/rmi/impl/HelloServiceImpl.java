package com.ggd543.rmi.impl;

import com.ggd543.rmi.HelloService;

import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.Unreferenced;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午1:06
 * To change this template use File | Settings | File Templates.
 */
public class HelloServiceImpl extends Object implements HelloService, Unreferenced {
    final private String name;

    
    public HelloServiceImpl(String name) throws RemoteException {
        this.name = name;
        UnicastRemoteObject.exportObject(this,0);
    }

    public HelloServiceImpl(ActivationID id, MarshalledObject data) throws IOException, ClassNotFoundException {
        this.name = (String) data.get();
        Activatable.exportObject(this,id,0);  //将本地对象导出为可激活对象
        System.out.println("创建: "+this.name);
    }

    public String echo(String msg) throws RemoteException {
        String pre = "Hello, ";
        System.out.println("receive  " + msg);
        return pre + msg;
    }

    public Date getTime() throws RemoteException {
        Date d = new Date();
        System.out.println("Now is " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
        return d;
    }

    @Override
    public boolean isAccessed() throws RemoteException {
        return isAccessed;
    }

    private boolean isAccessed = false;

    @Override
    public void access() throws RemoteException {
        System.out.println("HelloServiceImpl: 我被一个客户远程引用");
        isAccessed = true;
    }

    @Override
    public void bye() throws RemoteException {
        System.out.println("HelloServiceImpl: 一个客户不再引用我了");
    }

    @Override
    public void unreferenced() {
        System.out.println("HelloServiceImpl: 我不再被远程引用了");

    }
}
