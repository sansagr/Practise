package org.example.ordermanagementsystem;

import java.util.Map;

public class Catalog {
    public Map<Integer,Item> items;

    public Catalog(Map<Integer, Item> items){
        this.items = items;
    }

    public Map<Integer,Item> getItems(){
        return Map.copyOf(this.items);
    }

    public void addOrUpdateItem(Item item){
            items.put(item.getId(), item);
    }

    public void removeItem(Item item){
            items.remove(item.getId());
    }

    public void displayCatalog(){
        items.forEach((itemId, item) -> {
            System.out.println("these are the items we have");
            System.out.println(item.getName() + " " + item.getCost());
        });
    }
}

