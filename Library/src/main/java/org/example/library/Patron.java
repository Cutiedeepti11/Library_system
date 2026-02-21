package org.example.library;

import java.util.ArrayList;
import java.util.List;

public class Patron implements Observer {
    private String memberId;
    private String name;
    private List<Book> borrowingHistory;

    public Patron(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowingHistory = new ArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    
    public void addToHistory(Book book) {
        borrowingHistory.add(book);
    }

    @Override
    public void update(Book book) {
        // Triggered when a reserved book becomes available
        System.out.println("Notification for " + name + ": The book '" + book.getTitle() + "' is now available!");
    }
}
