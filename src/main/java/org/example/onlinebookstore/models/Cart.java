package org.example.onlinebookstore.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cart {
    private String userId;
    private Map<String, CartItem> items;
    private double totalPrice;

    public Cart(String userId){
        this.items = new HashMap<>();
        this.userId = userId;
        this.totalPrice = 0.0;
    }

}
