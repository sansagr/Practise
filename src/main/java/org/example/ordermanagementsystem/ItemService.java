package org.example.ordermanagementsystem;

import java.util.Map;

public class ItemService {
    private Catalog catalog;
    private Inventory inventory;

    public ItemService(Catalog catalog, Inventory inventory){
        this.catalog = catalog;
        this.inventory = inventory;
    }

    public void displayInventory() {
        for (Map.Entry<Integer, Item>  entry : catalog.getItems().entrySet()){
            int itemId = entry.getKey();
            Item item = entry.getValue();
            int quantity = inventory.getStock(itemId);
            System.out.println("Name :" + item.getName() + ", Quantity " + quantity  );
        }
    }
}
