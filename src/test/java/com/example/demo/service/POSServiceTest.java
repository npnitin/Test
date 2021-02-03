package com.example.demo.service;

import com.example.demo.bo.Cart;
import com.example.demo.bo.ProductItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POSServiceTest {

    List<ProductItem> productItems = new ArrayList<>();
    Cart cart = new Cart();
    Map<ProductItem,Integer> orderItems = new HashMap<>();
    POSService service = new POSServiceImpl();

    @BeforeAll
    public void init(){
        ProductItem apple = new ProductItem("0123","Apple",1.66);
        ProductItem orange = new ProductItem("0124","Orange",1.33);
        ProductItem banana = new ProductItem("0126","Banana",0.66);
    }

    @Test
    public void addItem(){
        Cart cart = new Cart();
        Map<String,Integer> orderItems = new HashMap<>();
        cart.setOrderItems(orderItems);
        cart = service.addItem(cart,"0123",2);
        Assert.assertEquals(cart.getOrderItems().size(),1);
    }

    @Test
    public void removeItem(){
        Cart cart = new Cart();
        Map<String,Integer> orderItems = new HashMap<>();
        cart.setOrderItems(orderItems);
        cart = service.addItem(cart,"0123",2);//added two qty
        cart = service.removeItem(cart,"0123",1);//remove one qty
        Assert.assertEquals(cart.getOrderItems().get("0123").intValue(),1);
    }

    @Test
    public void emptyCart(){
        Cart cart = new Cart();
        Map<String,Integer> orderItems = new HashMap<>();
        cart.setOrderItems(orderItems);
        cart = service.addItem(cart,"0123",2);//added item
        cart = service.removeItem(cart,"0123",2);//removed same qty so cart becomes empty
        Assert.assertEquals(cart.getOrderItems().size(),0);
    }
}
