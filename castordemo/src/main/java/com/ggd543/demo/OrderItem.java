package com.ggd543.demo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-27
 * Time: 下午7:36
 * To change this template use File | Settings | File Templates.
 */
public class OrderItem {

    private String id;
    private Integer orderQuantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "id: " + id + " orderQuantity: " + orderQuantity;
    }
}