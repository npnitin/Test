package com.example.demo.bo;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,Integer> orderItems = new HashMap<>();

    public Map<String, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<String, Integer> orderItems) {
        this.orderItems = orderItems;
    }
}
