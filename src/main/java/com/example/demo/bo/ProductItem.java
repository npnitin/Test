package com.example.demo.bo;

public class ProductItem {

    private String Id;
    private String name;
    private double price;

    public ProductItem(String id, String name, double price) {
        Id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
