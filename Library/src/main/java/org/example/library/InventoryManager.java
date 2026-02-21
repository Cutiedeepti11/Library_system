package org.example.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

public class InventoryManager {
    private static final Logger logger = Logger.getLogger(InventoryManager.class.getName());
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        logger.info("Added book: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        inventory.remove(isbn);
        logger.info("Removed book with ISBN: " + isbn);
    }

    public Book getBookByIsbn(String isbn) {
        return inventory.get(isbn);
    }

    public List<Book> searchBooks(SearchStrategy strategy, String query) {
        return strategy.search(inventory.values(), query);
    }
}

