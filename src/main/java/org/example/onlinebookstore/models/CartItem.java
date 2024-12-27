package org.example.onlinebookstore.models;

import lombok.Data;

@Data
public class CartItem {
    private String bookId;
    private Book book;
    private int quantity;

    public CartItem(String bookId, int quantity, Book book){
        this.bookId = bookId;
        this.quantity = quantity;
        this.book = book;
    }
}
