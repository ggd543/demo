package com.ggd543.demo.jdo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-29
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
public class Catalogue {

    private long id;
    private String name;
    private List<Product> products = new ArrayList<Product>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

}
