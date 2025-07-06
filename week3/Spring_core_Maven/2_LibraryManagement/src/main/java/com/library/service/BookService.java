package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository repository;

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void showAllBooks() {
        System.out.println("Service: Preparing to fetch books...");
        repository.printBooks();
    }
}