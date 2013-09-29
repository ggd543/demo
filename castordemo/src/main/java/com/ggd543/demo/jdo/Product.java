package com.ggd543.demo.jdo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-29
 * Time: 上午10:38
 * To change this template use File | Settings | File Templates.
 */
public class Product {
    private Long id;

    private String description;

    private Catalogue catalogue;

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Product() {
    }

    public Product(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Product(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id: " + id + " desc: " + description + " catalogue: " + catalogue;
    }
}
