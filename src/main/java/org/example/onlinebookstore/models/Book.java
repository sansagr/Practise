package org.example.onlinebookstore.models;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String name;
    private String author;
    private String publishedDate;
    private int price;
    private String language;
    private String category;

    public Book(String id, String name, String author, String publishedDate, int price, String language, String category){
        this.id = id;
        this.name = name;
        this.author =  author;
        this.publishedDate = publishedDate;
        this.price = price;
        this.language = language;
        this.category = category;
    }
}
