package com.example.demo.service;

import com.example.demo.bo.Cart;
import com.example.demo.bo.ProductItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POSServiceImpl implements  POSService {

    @Override
    public Cart addItem(Cart cart, String s, int count) {
        List<ProductItem> items = getItems();
        if(cart.getOrderItems()!=null){
            for(ProductItem item:items){
                if(item.getId().equalsIgnoreCase(s)){
                    cart.getOrderItems().put(s,count);
                }
            }

        }else{
            Map<String,Integer> itemsMap = new HashMap<>();
            for(ProductItem item:items){
                if(item.getId().equalsIgnoreCase(s)){
                    itemsMap.put(s,count);
                }
            }
            cart.setOrderItems(itemsMap);
        }
    return cart;
    }

    @Override
    public Cart removeItem(Cart cart, String itemCode, int qty) {
        if(cart.getOrderItems().size() == 0){
            //throw exeption and return
        }else{
            int count = cart.getOrderItems().get(itemCode);
            if(qty>count){
                //exception
            }else{
                int newCount = count -qty;
                if(newCount!=0){
                    cart.getOrderItems().put(itemCode,newCount );
                }else{
                    cart.getOrderItems().remove(itemCode);
                }

            }
        }
        return cart;
    }


    //this is call to product service basically
    public static List<ProductItem> getItems(){
        List<ProductItem> items = new ArrayList<>();
        ProductItem apple = new ProductItem("0123","Apple",1.66);
        ProductItem orange = new ProductItem("0124","Orange",1.33);
        ProductItem banana = new ProductItem("0126","Banana",0.66);
        items.add(apple);
        items.add(orange);
        items.add(banana);
        return items;
    }
}
