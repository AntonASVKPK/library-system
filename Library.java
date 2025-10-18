package com.library;

import java.util.*;

public class Library {
    private final Map<String, Book> booksByIsbn = new HashMap<>();

    public void addBook(Book book) {
        if (booksByIsbn.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Книга с ISBN " + book.getIsbn() + " уже существует.");
        }
        booksByIsbn.put(book.getIsbn(), book);
    }

    public void borrowBook(String isbn) {
        Book book = booksByIsbn.get(isbn);
        if (book == null) {
            throw new NoSuchElementException("Книга с ISBN " + isbn + " не найдена.");
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("Книга уже взята.");
        }
        book.setAvailable(false);
    }

    public void returnBook(String isbn) {
        Book book = booksByIsbn.get(isbn);
        if (book == null) {
            throw new NoSuchElementException("Книга с ISBN " + isbn + " не найдена.");
        }
        if (book.isAvailable()) {
            throw new IllegalStateException("Книга уже в библиотеке.");
        }
        book.setAvailable(true);
    }

    public List<Book> listAvailableBooks() {
        return booksByIsbn.values().stream()
                .filter(Book::isAvailable)
                .toList();
    }
}