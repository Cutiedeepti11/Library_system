package org.example.library;

import java.util.Collection;
import java.util.List;

public interface SearchStrategy {
    List<Book> search(Collection<Book> books, String query);
}