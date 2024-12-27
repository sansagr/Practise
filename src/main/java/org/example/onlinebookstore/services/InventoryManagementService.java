package org.example.onlinebookstore.services;

import org.example.onlinebookstore.repositories.BookInventoryRepository;

public class InventoryManagementService {
    private final BookInventoryRepository inventoryRepository;

    public InventoryManagementService(BookInventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public void addOrUpdateInventory(String bookId, int quantity){
        inventoryRepository.addBook(bookId, quantity);
    }

    public void removeItemFromInventory(String bookId){
        inventoryRepository.removeBook(bookId);
    }

}
