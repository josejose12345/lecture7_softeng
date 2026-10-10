package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Library {

    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        Objects.requireNonNull(book, "book must not be null");
        books.add(book);
    }

    /**
     * Removes the first book equal to the given one.
     *
     * @return true if a book was removed, false otherwise
     */
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    /** Returns the books whose author matches, ignoring case. */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    /** Returns the books published in the given year. */
    public List<Book> getBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    /** Read-only view of all books in the library. */
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
}
