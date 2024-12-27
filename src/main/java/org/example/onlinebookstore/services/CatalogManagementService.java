package org.example.onlinebookstore.services;

import org.example.onlinebookstore.models.Book;
import org.example.onlinebookstore.repositories.BookRepository;

public class CatalogManagementService {
    private BookRepository bookRepository;

    public CatalogManagementService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    public void updateBookMetadat(String bookId, String metadata){

    }

    public void removeBook(String bookId){

    }
}
