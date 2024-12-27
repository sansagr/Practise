package org.example.onlinebookstore.services;

import org.example.onlinebookstore.models.Book;
import org.example.onlinebookstore.repositories.BookRepository;

import java.util.List;
import java.util.Objects;

public class SearchService {
    private final BookRepository bookRepository;

    public SearchService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> searchService(String query, String searchOption){
        if (Objects.equals(searchOption, "name")){
            return bookRepository.findByName(query);
        } else if (Objects.equals(searchOption, "author")) {
            return bookRepository.findByAuthor(query);
        } else if (Objects.equals(searchOption, "category")) {
            return bookRepository.findByCategory(query);
        }
        else{
            return null;
        }
    }
}
