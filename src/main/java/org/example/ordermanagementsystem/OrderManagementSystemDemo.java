package org.example.ordermanagementsystem;

import java.util.Map;

public class OrderManagementSystemDemo {
    public static void main(String[] args) {
        Catalog catalog = new Catalog(Map.of(
                1, new Item(1, "Laptop", 1000),
                2, new Item(2, "Phone", 500)
        ));

        Inventory inventory = new Inventory();
        inventory.addStock(1, 10); // Laptop: 10 units
        inventory.addStock(2, 5);  // Phone: 5 units

// Display items with quantities
        ItemService itemService = new ItemService(catalog, inventory);
        itemService.displayInventory();
    }
}
