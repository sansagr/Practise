package org.example.onlinebookstore.repositories;


import org.example.onlinebookstore.models.Book;

import java.util.*;

public class BookRepository {
    private final Map<String, Book> bookDatabase;

    public BookRepository(List<Book> bookList){
        Map<String, Book> bookMap = new HashMap<>();
        for (Book book : bookList){
            bookMap.putIfAbsent(book.getId(), book);
        }

        this.bookDatabase = bookMap;
    }

    public void addBook(Book book){
        bookDatabase.putIfAbsent(book.getId(), book);
    }

    public void removeBook(String bookId){
        bookDatabase.remove(bookId);
    }

    public Book getBook(String bookId){
        return bookDatabase.getOrDefault(bookId, null);
    }

    public List<Book> findByName(String name){
        List<Book> foundBooks = new ArrayList<>();
        bookDatabase.forEach((key, value) -> {
            if (Objects.equals(value.getName(), name)){
                foundBooks.add(value);
            }
        });

        return foundBooks;
    }

    public List<Book> findByAuthor(String author){
        List<Book> foundBooks = new ArrayList<>();
        bookDatabase.forEach((key, value) -> {
            if (Objects.equals(value.getAuthor(), author)){
                foundBooks.add(value);
            }
        });

        return foundBooks;
    }

    public List<Book> findByCategory(String category){
        List<Book> foundBooks = new ArrayList<>();
        bookDatabase.forEach((key, value) -> {
            if (Objects.equals(value.getCategory(), category)){
                foundBooks.add(value);
            }
        });

        return foundBooks;
    }

//    Bunch of methods to update metadata of book

}
