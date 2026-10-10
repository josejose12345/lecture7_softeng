package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void equalBooksWithSameFields() {
        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("1984", "George Orwell", 1949);
        assertEquals(b1, b2);
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    public void differentYearMeansNotEqual() {
        assertNotEquals(new Book("1984", "George Orwell", 1949),
                        new Book("1984", "George Orwell", 1950));
    }

    @Test
    public void differentTitleOrAuthorMeansNotEqual() {
        Book base = new Book("1984", "George Orwell", 1949);
        assertNotEquals(base, new Book("Animal Farm", "George Orwell", 1949));
        assertNotEquals(base, new Book("1984", "Aldous Huxley", 1949));
    }

    @Test
    public void notEqualToNullOrOtherType() {
        Book book = new Book("1984", "George Orwell", 1949);
        assertNotEquals(null, book);
        assertNotEquals("1984", book);
    }

    @Test
    public void gettersReturnConstructorValues() {
        Book book = new Book("Dune", "Frank Herbert", 1965);
        assertEquals("Dune", book.getTitle());
        assertEquals("Frank Herbert", book.getAuthor());
        assertEquals(1965, book.getYear());
    }

    @Test
    public void nullTitleIsRejected() {
        assertThrows(NullPointerException.class, () -> new Book(null, "Author", 2000));
    }

    @Test
    public void nullAuthorIsRejected() {
        assertThrows(NullPointerException.class, () -> new Book("Title", null, 2000));
    }
}
