package org.example.library;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TitleSearchStrategy implements SearchStrategy {
    
    @Override
    public List<Book> search(Collection<Book> books, String query) {
        // We use Java Streams to filter the books ignoring case sensitivity
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}