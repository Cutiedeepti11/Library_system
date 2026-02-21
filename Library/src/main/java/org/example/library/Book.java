package org.example.library;

import java.util.*;

// --- Entities ---

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
    
    // For Observer Pattern (Reservation System)
    private Queue<Observer> reservationQueue = new LinkedList<>();

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { 
        this.isAvailable = available; 
        if(available) notifyObservers();
    }

    // Observer methods
    public void addReservation(Observer observer) {
        reservationQueue.offer(observer);
    }
    private void notifyObservers() {
        if (!reservationQueue.isEmpty()) {
            Observer nextInLine = reservationQueue.poll();
            nextInLine.update(this);
        }
    }
}

