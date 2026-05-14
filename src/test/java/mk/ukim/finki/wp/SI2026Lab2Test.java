package mk.ukim.finki.wp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void searchBookEveryStatementTest() {
        assertThrows(IllegalArgumentException.class, () -> library.searchBookByTitle(""));

        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        List<Book> result = library.searchBookByTitle("Clean Code");
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Clean Code", result.get(0).getTitle());

        assertNull(library.searchBookByTitle("Harry Potter"));
    }


    @Test
    void borrowBookEveryBranchTest() {
        assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook("", "Robert C. Martin"));

        assertThrows(RuntimeException.class,
                () -> library.borrowBook("Непостоечка книга", "Непознат автор"));

        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        assertDoesNotThrow(() -> library.borrowBook("The Hobbit", "J.R.R. Tolkien"));
        assertThrows(RuntimeException.class,
                () -> library.borrowBook("The Hobbit", "J.R.R. Tolkien"));

        library.addBook(new Book("1984", "George Orwell", "Dystopian"));
        assertThrows(RuntimeException.class,
                () -> library.borrowBook("1984", "Друг Автор"));
    }


    @Test
    void searchBookMultipleConditionTest() {
        Book book = new Book("Clean Code", "Robert C. Martin", "Programming");
        library.addBook(book);

        List<Book> res1 = library.searchBookByTitle("Clean Code");
        assertNotNull(res1);
        assertEquals(1, res1.size());

        book.setBorrowed(true);
        assertNull(library.searchBookByTitle("Clean Code"));

        book.setBorrowed(false);
        assertNull(library.searchBookByTitle("Effective Java"));

        book.setBorrowed(true);
        assertNull(library.searchBookByTitle("Effective Java"));
    }


    @Test
    void borrowBookMultipleConditionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook("", ""));

        assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook("", "Robert C. Martin"));

        assertThrows(IllegalArgumentException.class,
                () -> library.borrowBook("Clean Code", ""));

        assertThrows(RuntimeException.class,
                () -> library.borrowBook("Clean Code", "Robert C. Martin"));
        assertFalse(assertThrows(RuntimeException.class,
                () -> library.borrowBook("Clean Code", "Robert C. Martin"))
                instanceof IllegalArgumentException);
    }
}