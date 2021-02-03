package com.example.demo.service;

import com.example.demo.bo.Cart;

public interface POSService {

    public Cart addItem(Cart cart, String s, int i);

    public Cart removeItem(Cart cart,String itemCode,int qty);
}
