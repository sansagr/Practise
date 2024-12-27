package org.example.onlinebookstore.models;

import lombok.Data;

@Data
public class OrderItem {
    private String itemId;
    private String name;
    private int quantity;
    private double price;

    public OrderItem(String itemId, String name, int quantity, double price){
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
