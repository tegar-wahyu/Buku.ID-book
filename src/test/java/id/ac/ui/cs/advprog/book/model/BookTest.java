package id.ac.ui.cs.advprog.book.model;

import id.ac.ui.cs.advprog.book.model.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    Book book1 = new Book();
    Book book2 = new Book();

    @BeforeEach
    public void setUp() {
        book1 = new Book(1, "Sampo Cap Bambang", "Bambang", "Bambang CV", 10.99f, 100, "1234567890",
                "sampo_cap_bambang.jpg", "1988-09-29", "Children's Books", 50,
                "A children's book about Sampo Cap Bambang adventures.");
        book2 = new Book(2, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Penguin Classics", 8.50f, 75,
                "9780140439070", "sherlock_holmes.jpg", "1999-09-29", "Mystery", 320,
                "A collection of twelve stories featuring Sherlock Holmes, a consulting detective.");
    }

    @Test
    void testBook1() {
        assertEquals(1, book1.getId());
        assertEquals("Sampo Cap Bambang", book1.getTitle());
        assertEquals("Bambang", book1.getAuthor());
        assertEquals("Bambang CV", book1.getPublisher());
        assertEquals(10.99f, book1.getPrice());
        assertEquals(100, book1.getStock());
        assertEquals("1234567890", book1.getIsbn());
        assertEquals("sampo_cap_bambang.jpg", book1.getBookPict());
        assertEquals("1988-09-29", book1.getPublishDate());
        assertEquals("Children's Books", book1.getCategory());
        assertEquals(50, book1.getPage());
        assertEquals("A children's book about Sampo Cap Bambang adventures.", book1.getDesc());
    }

    @Test
    void testBook2() {
        assertEquals(2, book2.getId());
        assertEquals("The Adventures of Sherlock Holmes", book2.getTitle());
        assertEquals("Arthur Conan Doyle", book2.getAuthor());
        assertEquals("Penguin Classics", book2.getPublisher());
        assertEquals(8.50f, book2.getPrice());
        assertEquals(75, book2.getStock());
        assertEquals("9780140439070", book2.getIsbn());
        assertEquals("sherlock_holmes.jpg", book2.getBookPict());
        assertEquals("1999-09-29", book2.getPublishDate());
        assertEquals("Mystery", book2.getCategory());
        assertEquals(320, book2.getPage());
        assertEquals("A collection of twelve stories featuring Sherlock Holmes, a consulting detective.",
                book2.getDesc());
    }

    @Test
    void testSetIdWithNull() {
        assertThrows(IllegalArgumentException.class, () -> book1.setID(null));
    }

    @Test
    void testSetTitleWithNull() {
        assertThrows(IllegalArgumentException.class, () -> book1.setTitle(null));
    }
}