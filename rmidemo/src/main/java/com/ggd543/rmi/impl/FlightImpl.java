package com.ggd543.rmi.impl;

import com.ggd543.rmi.Flight;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-11
 * Time: 下午7:34
 * To change this template use File | Settings | File Templates.
 */
public class FlightImpl  implements Flight , Serializable {
    private String flightNumber;
    private Date flightDate;
    private String originCity;
    private String destCity;

    @Override
    public String toString(){
        return "flightNumber: "+flightNumber+" flightDate: "+flightDate+" originCity: "+originCity+" destCity: "+destCity;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof  FlightImpl){
            FlightImpl that = (FlightImpl) o;
            return that.flightNumber.equals(this.flightNumber);
        }else{
            return false;
        }
    }
    
    public  FlightImpl(String flightNumber) throws  RemoteException{
        this.flightNumber = flightNumber;
//        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public String getFlightNumber() throws RemoteException {
       return this.flightNumber;
    }

    @Override
    public void setFlightNumber(String num) throws RemoteException {
        this.flightNumber = num;
    }

    @Override
    public String getOriginCity() throws RemoteException {
        return this.originCity;
    }

    @Override
    public void setOriginCity(String city) throws RemoteException {
        this.originCity = city;
        
    }

    @Override
    public String getDestCity() throws RemoteException {
        return this.destCity;
    }

    @Override
    public void setDestCity(String city) throws RemoteException {
        this.destCity = city;
    }

    @Override
    public Date getFlightDate() throws RemoteException {
        return this.flightDate;
    }

    @Override
    public void setFlightDate(Date date) throws RemoteException {
        this.flightDate = date;
    }
}
