package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private Book orwell1984;
    private Book orwellAnimalFarm;
    private Book herbertDune;

    @BeforeEach
    public void setUp() {
        library = new Library();
        orwell1984 = new Book("1984", "George Orwell", 1949);
        orwellAnimalFarm = new Book("Animal Farm", "George Orwell", 1945);
        herbertDune = new Book("Dune", "Frank Herbert", 1965);
        library.addBook(orwell1984);
        library.addBook(orwellAnimalFarm);
        library.addBook(herbertDune);
    }

    @Test
    public void addBookIncreasesSize() {
        library.addBook(new Book("Emma", "Jane Austen", 1815));
        assertEquals(4, library.getBooks().size());
    }

    @Test
    public void addNullBookIsRejected() {
        assertThrows(NullPointerException.class, () -> library.addBook(null));
    }

    @Test
    public void removeExistingBook() {
        assertTrue(library.removeBook(orwell1984));
        assertEquals(2, library.getBooks().size());
        assertFalse(library.getBooks().contains(orwell1984));
    }

    @Test
    public void removeMissingBookReturnsFalse() {
        assertFalse(library.removeBook(new Book("Emma", "Jane Austen", 1815)));
        assertEquals(3, library.getBooks().size());
    }

    @Test
    public void removeUsesContentEquality() {
        // A different object with the same fields should remove the stored book
        assertTrue(library.removeBook(new Book("Dune", "Frank Herbert", 1965)));
        assertEquals(2, library.getBooks().size());
    }

    @Test
    public void getBooksByAuthorReturnsAllMatches() {
        List<Book> result = library.getBooksByAuthor("George Orwell");
        assertEquals(2, result.size());
        assertTrue(result.contains(orwell1984));
        assertTrue(result.contains(orwellAnimalFarm));
    }

    @Test
    public void getBooksByAuthorIgnoresCase() {
        assertEquals(2, library.getBooksByAuthor("george orwell").size());
    }

    @Test
    public void getBooksByUnknownAuthorIsEmpty() {
        assertTrue(library.getBooksByAuthor("Jane Austen").isEmpty());
    }

    @Test
    public void getBooksByYearReturnsMatches() {
        List<Book> result = library.getBooksByYear(1965);
        assertEquals(List.of(herbertDune), result);
    }

    @Test
    public void getBooksByYearWithNoMatchesIsEmpty() {
        assertTrue(library.getBooksByYear(2000).isEmpty());
    }

    @Test
    public void getBooksReturnsReadOnlyView() {
        List<Book> books = library.getBooks();
        assertThrows(UnsupportedOperationException.class,
                     () -> books.add(new Book("Emma", "Jane Austen", 1815)));
    }
}
