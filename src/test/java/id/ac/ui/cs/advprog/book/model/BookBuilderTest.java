package id.ac.ui.cs.advprog.book.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BookBuilderTest {
    private BookBuilder bookBuilder;
    Date date1 = new Date();

    @BeforeEach
    public void setUp() {
        bookBuilder = new BookBuilder();
    }

    @Test
    void testBook1() {
        Book book1 = bookBuilder
                .setIdBook(1)
                .setTitle("Buku Pak Bambang")
                .setAuthor("Pak Bambang")
                .setPublisher("Pak Bambang CV")
                .setPrice(10.99f)
                .setStock(100)
                .setIsbn("1234567890")
                .setBookPict("buku_pak_bambang.jpg")
                .setPublishDate(date1)
                .setCategory("Children's Books")
                .setPage(50)
                .setDesc("A children's book about Pak Bambang adventures.")
                .build();

        assertEquals(1, book1.getIdBook());
        assertEquals("Buku Pak Bambang", book1.getTitle());
        assertEquals("Pak Bambang", book1.getAuthor());
        assertEquals("Pak Bambang CV", book1.getPublisher());
        assertEquals(10.99f, book1.getPrice());
        assertEquals(100, book1.getStock());
        assertEquals("1234567890", book1.getIsbn());
        assertEquals("buku_pak_bambang.jpg", book1.getBookPict());
        assertEquals(date1, book1.getPublishDate());
        assertEquals("Children's Books", book1.getCategory());
        assertEquals(50, book1.getPage());
        assertEquals("A children's book about Pak Bambang adventures.", book1.getDesc());
    }

    @Test
    void testBuildBookWithMissingTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            bookBuilder
                    .setAuthor("Pak Bambang")
                    .setPrice(10.99f)
                    .build();
        });
    }

    @Test
    void testBuildBookWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            bookBuilder
                    .setTitle("Buku Pak Bambang")
                    .setAuthor("Pak Bambang")
                    .setPrice(-10.99f)
                    .build();
        });
    }

    @Test
    void testBuildBookWithMissingAuthor() {
        assertThrows(IllegalArgumentException.class, () -> {
            bookBuilder
                    .setTitle("Buku Pak Bambang")
                    .setPrice(10.99f)
                    .build();
        });
    }
}