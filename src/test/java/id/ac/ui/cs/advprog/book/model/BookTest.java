package id.ac.ui.cs.advprog.book.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    Book book1 = new Book();
    Book book2 = new Book();

    Date date1 = new Date();
    Date date2 = new Date();

    @BeforeEach
    public void setUp() {
        book1.setIdBook(1);
        book1.setTitle("Sampo Cap Bambang");
        book1.setAuthor("Bambang");
        book1.setPublisher("Bambang CV");
        book1.setPrice(10.99f);
        book1.setStock(100);
        book1.setIsbn("1234567890");
        book1.setBookPict("sampo_cap_bambang.jpg");
        book1.setPublishDate(date1);
        book1.setCategory("Children's Books");
        book1.setPage(50);
        book1.setDesc("A children's book about Sampo Cap Bambang adventures.");

        book2.setIdBook(2);
        book2.setTitle("The Adventures of Sherlock Holmes");
        book2.setAuthor("Arthur Conan Doyle");
        book2.setPublisher("Penguin Classics");
        book2.setPrice(8.50f);
        book2.setStock(75);
        book2.setIsbn("9780140439070");
        book2.setBookPict("sherlock_holmes.jpg");
        book2.setPublishDate(date2);
        book2.setCategory("Mystery");
        book2.setPage(320);
        book2.setDesc("A collection of twelve stories featuring Sherlock Holmes, a consulting detective.");
    }

    @Test
    void testBook1() {
        assertEquals(1, book1.getIdBook());
        assertEquals("Sampo Cap Bambang", book1.getTitle());
        assertEquals("Bambang", book1.getAuthor());
        assertEquals("Bambang CV", book1.getPublisher());
        assertEquals(10.99f, book1.getPrice());
        assertEquals(100, book1.getStock());
        assertEquals("1234567890", book1.getIsbn());
        assertEquals("sampo_cap_bambang.jpg", book1.getBookPict());
        assertEquals(date1, book1.getPublishDate());
        assertEquals("Children's Books", book1.getCategory());
        assertEquals(50, book1.getPage());
        assertEquals("A children's book about Sampo Cap Bambang adventures.", book1.getDesc());
    }

    @Test
    void testBook2() {
        assertEquals(2, book2.getIdBook());
        assertEquals("The Adventures of Sherlock Holmes", book2.getTitle());
        assertEquals("Arthur Conan Doyle", book2.getAuthor());
        assertEquals("Penguin Classics", book2.getPublisher());
        assertEquals(8.50f, book2.getPrice());
        assertEquals(75, book2.getStock());
        assertEquals("9780140439070", book2.getIsbn());
        assertEquals("sherlock_holmes.jpg", book2.getBookPict());
        assertEquals(date2, book2.getPublishDate());
        assertEquals("Mystery", book2.getCategory());
        assertEquals(320, book2.getPage());
        assertEquals("A collection of twelve stories featuring Sherlock Holmes, a consulting detective.",
                book2.getDesc());
    }

    @Test
    void testSetTitleWithNull() {
        assertThrows(IllegalArgumentException.class, () -> book1.setTitle(null));
    }
}