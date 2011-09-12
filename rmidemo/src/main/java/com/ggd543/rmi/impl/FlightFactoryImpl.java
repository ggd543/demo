package com.ggd543.rmi.impl;

import com.ggd543.rmi.Flight;
import com.ggd543.rmi.FlightFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午7:36
 * To change this template use File | Settings | File Templates.
 */
public class FlightFactoryImpl extends UnicastRemoteObject implements FlightFactory{
    private HashMap<String, Flight> flightTable = new HashMap<String, Flight>();

    public FlightFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public Flight getFlight(String flightNumber) throws RemoteException {
        synchronized(this){
            if (flightTable.containsKey(flightNumber)) {
                System.out.println("get from HashTable for "+flightNumber);
                return flightTable.get(flightNumber);
            } else{
                Flight flight = new FlightImpl(flightNumber);
                flightTable.put(flightNumber, flight);
                return flight;
            }
        }
    }
}

