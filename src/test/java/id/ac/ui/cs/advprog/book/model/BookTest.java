package id.ac.ui.cs.advprog.book.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    BookBuilder bookBuilder = new BookBuilder();

    Book book1;
    Book book2;

    Date date1 = new Date();
    Date date2 = new Date();

    @BeforeEach
    public void setUp() {
        book1 =
                bookBuilder.setIdBook(1)
                .setTitle("Sampo Cap Bambang")
                .setAuthor("Bambang")
                .setPublisher("Bambang CV")
                .setPrice(10.99f)
                .setStock(100)
                .setIsbn("1234567890")
                .setBookPict("sampo_cap_bambang.jpg")
                .setPublishDate(date1)
                .setCategory("Children's Books")
                .setPage(50)
                .setDesc("A children's book about Sampo Cap Bambang adventures.")
                .build();

        book2 = bookBuilder.setIdBook(2)
                .setTitle("The Adventures of Sherlock Holmes")
                .setAuthor("Arthur Conan Doyle")
                .setPublisher("Penguin Classics")
                .setPrice(8.50f)
                .setStock(75)
                .setIsbn("9780140439070")
                .setBookPict("sherlock_holmes.jpg")
                .setPublishDate(date2)
                .setCategory("Mystery")
                .setPage(320)
                .setDesc("A collection of twelve stories featuring Sherlock Holmes, a consulting detective.")
                .build();
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
}