package com.ggd543.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午7:31
 * To change this template use File | Settings | File Templates.
 */
public interface Flight{
    public String getFlightNumber() throws RemoteException;
    public void setFlightNumber(String num) throws RemoteException;

    public String getOriginCity() throws RemoteException;
    public void setOriginCity(String city) throws RemoteException;


    public String getDestCity() throws RemoteException;
    public void setDestCity(String city) throws RemoteException;

    public Date getFlightDate() throws RemoteException;
    public void setFlightDate(Date date) throws RemoteException;
    
}
