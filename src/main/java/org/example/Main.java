package org.example;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        run(new Scanner(System.in), System.out, new Library());
    }

    /**
     * Menu loop. Input and output are passed in so the loop does not depend on
     * System.in / System.out directly.
     */
    static void run(Scanner in, PrintStream out, Library library) {
        while (true) {
            printMenu(out);
            String option = prompt(in, out, "Option: ");
            if (option == null) {
                return; // end of input
            }
            switch (option) {
                case "1" -> addBook(in, out, library);
                case "2" -> removeBook(in, out, library);
                case "3" -> searchByAuthor(in, out, library);
                case "4" -> searchByYear(in, out, library);
                case "5" -> printBooks(out, library.getBooks());
                case "0" -> {
                    out.println("Goodbye!");
                    return;
                }
                default -> out.println("Unknown option.");
            }
        }
    }

    private static void printMenu(PrintStream out) {
        out.println();
        out.println("=== Library ===");
        out.println("1. Add book");
        out.println("2. Remove book");
        out.println("3. Search by author");
        out.println("4. Search by year");
        out.println("5. List all books");
        out.println("0. Exit");
    }

    private static void addBook(Scanner in, PrintStream out, Library library) {
        Book book = readBook(in, out);
        if (book == null) {
            return;
        }
        library.addBook(book);
        out.println("Book added: " + book);
    }

    private static void removeBook(Scanner in, PrintStream out, Library library) {
        Book book = readBook(in, out);
        if (book == null) {
            return;
        }
        if (library.removeBook(book)) {
            out.println("Book removed: " + book);
        } else {
            out.println("No such book in the library.");
        }
    }

    private static void searchByAuthor(Scanner in, PrintStream out, Library library) {
        String author = prompt(in, out, "Author: ");
        if (author == null) {
            return;
        }
        printBooks(out, library.getBooksByAuthor(author));
    }

    private static void searchByYear(Scanner in, PrintStream out, Library library) {
        Integer year = readYear(in, out);
        if (year == null) {
            return;
        }
        printBooks(out, library.getBooksByYear(year));
    }

    /** Asks for title, author and year. Returns null if input ended or a field is invalid. */
    private static Book readBook(Scanner in, PrintStream out) {
        String title = prompt(in, out, "Title: ");
        if (title == null) {
            return null;
        }
        String author = prompt(in, out, "Author: ");
        if (author == null) {
            return null;
        }
        Integer year = readYear(in, out);
        if (year == null) {
            return null;
        }
        if (title.isEmpty() || author.isEmpty()) {
            out.println("Title and author cannot be empty.");
            return null;
        }
        return new Book(title, author, year);
    }

    /** Asks until a valid integer is entered. Returns null if input ended. */
    private static Integer readYear(Scanner in, PrintStream out) {
        while (true) {
            String text = prompt(in, out, "Year: ");
            if (text == null) {
                return null;
            }
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                out.println("Please enter a valid year.");
            }
        }
    }

    private static void printBooks(PrintStream out, List<Book> books) {
        if (books.isEmpty()) {
            out.println("No books found.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            out.println((i + 1) + ". " + books.get(i));
        }
    }

    /** Prints the message and reads one line. Returns null at end of input. */
    private static String prompt(Scanner in, PrintStream out, String message) {
        out.print(message);
        return in.hasNextLine() ? in.nextLine().trim() : null;
    }
}
