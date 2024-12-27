package org.example.ordermanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Integer, Integer> stock;

    public Inventory(){
        this.stock = new HashMap<>();
    }

    public void addStock(int itemId, int quantity){
        stock.merge(itemId, quantity, Integer::sum);
    }

    public boolean reduceStock(int itemId, int quantity){
        if (stock.getOrDefault(itemId, 0) >=  quantity){
            stock.put(itemId, stock.get(itemId) - quantity);
            return true;
        }
        return false;
    }

    public int getStock(int itemId){
        return stock.getOrDefault(itemId, 0);
    }

}
