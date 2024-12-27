package org.example.onlinebookstore.repositories;

import org.example.onlinebookstore.models.Book;

import java.util.Map;

public class BookInventoryRepository {

    private final Map<String, Integer> bookInventoryDatabase;


    public BookInventoryRepository(Map<String, Integer> bookInventoryDatabase){
        this.bookInventoryDatabase = bookInventoryDatabase;
    }

    public void addBook(String bookId, int quantity){
        if (bookInventoryDatabase.containsKey(bookId)){
            bookInventoryDatabase.compute(bookId, (k, existingQuantity) -> existingQuantity + quantity);
        }
        else{
            bookInventoryDatabase.put(bookId, quantity);
        }
    }

    public Boolean containsBook(String bookId){
        return bookInventoryDatabase.containsKey(bookId);
    }

    public void removeBook(String bookId){
        bookInventoryDatabase.remove(bookId);
    }

    public void updateBookQuantity(String bookId, int quantity){
        if (bookInventoryDatabase.containsKey(bookId)){
            int existingQuantity = bookInventoryDatabase.get(bookId);
            if (quantity + existingQuantity <=0){
                removeBook(bookId);
            }
            else{
                bookInventoryDatabase.put(bookId, quantity+existingQuantity);
            }
        }
    }

    public int getBookQuantity(String bookId){
        if (bookInventoryDatabase.containsKey(bookId)){
            return bookInventoryDatabase.get(bookId);
        }
        return 0;
    }
}
