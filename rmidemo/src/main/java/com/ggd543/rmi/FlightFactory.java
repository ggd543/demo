package com.ggd543.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午7:30
 * To change this template use File | Settings | File Templates.
 */
public interface FlightFactory extends Remote {
    public Flight getFlight(String flightNumber) throws RemoteException;
    
}
