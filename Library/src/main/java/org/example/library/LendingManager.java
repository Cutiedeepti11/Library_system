package org.example.library;

import java.util.logging.Logger;

public class LendingManager {
    private static final Logger logger = Logger.getLogger(LendingManager.class.getName());

    public boolean checkoutBook(Book book, Patron patron) {
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            patron.addToHistory(book);
            logger.info("Book '" + book.getTitle() + "' checked out by " + patron.getName());
            return true;
        }
        logger.warning("Checkout failed: Book is unavailable or does not exist.");
        return false;
    }

    public void returnBook(Book book) {
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true); // This triggers the Observer notification
            logger.info("Book '" + book.getTitle() + "' was returned.");
        }
    }
}
