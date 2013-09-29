package com.ggd543.demo.xml;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-27
 * Time: 下午7:35
 * To change this template use File | Settings | File Templates.
 */
public class Order {

    private List orderItems;
    private String orderNumber;

    public List getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List orderItems) {
        this.orderItems = orderItems;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}