package org.example.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private InventoryManager inventoryManager;
    private LendingManager lendingManager;
    private Map<String, Patron> patrons;

    public Library() {
        this.inventoryManager = new InventoryManager();
        this.lendingManager = new LendingManager();
        this.patrons = new HashMap<>();
    }

    // --- Book Delegation ---
    public void registerBook(Book book) {
        inventoryManager.addBook(book);
    }

    public List<Book> findBooks(SearchStrategy strategy, String query) {
        return inventoryManager.searchBooks(strategy, query);
    }

    // --- Patron Management ---
    public void registerPatron(Patron patron) {
        patrons.put(patron.getMemberId(), patron);
    }

    // --- Lending Delegation ---
    public void borrowBook(String isbn, String patronId) {
        Book book = inventoryManager.getBookByIsbn(isbn);
        Patron patron = patrons.get(patronId);
        if (patron != null) {
            lendingManager.checkoutBook(book, patron);
        }
    }

    public void returnBook(String isbn) {
        Book book = inventoryManager.getBookByIsbn(isbn);
        lendingManager.returnBook(book);
    }

    // --- Reservation Delegation ---
    public void reserveBook(String isbn, String patronId) {
        Book book = inventoryManager.getBookByIsbn(isbn);
        Patron patron = patrons.get(patronId);
        if (book != null && patron != null && !book.isAvailable()) {
            book.addReservation(patron);
        }
    }
}