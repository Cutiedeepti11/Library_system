package org.example.library;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByAuthor implements SearchStrategy {
    @Override
    public List<Book> search(Collection<Book> books, String query) {
        return books.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
