package id.ac.ui.cs.advprog.book.repository;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.model.BookBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    BookRepository bookRepository;
    BookBuilder bookBuilder = new BookBuilder();

    Book book1;
    Book book2;

    Date date1 = new Date();
    Date date2 = new Date();

    List <Book> books = new ArrayList<>();

    @BeforeEach
    void setUp() {
        BookRepository bookRepository = new BookRepository();
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
    void testSave() {
        Book book = books.get(1);
        Book result = bookRepository.save(book);

        Book findResult = bookRepository.findById(books.get(1).getIdBook());
        assertEquals(book.getIdBook(), result.getIdBook());
        assertEquals(book.getIdBook(), findResult.getIdBook());
        assertEquals(book.getTitle(), findResult.getTitle());
        assertEquals(book.getAuthor(), findResult.getAuthor());
    }

    @Test
    void testFindByIdFound() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        Book findResult = bookRepository.findById(books.get(1).getIdBook());
        assertEquals(books.get(1).getIdBook(), findResult.getIdBook());
        assertEquals(books.get(1).getTitle(), findResult.getTitle());
        assertEquals(books.get(1).getAuthor(), findResult.getAuthor());
    }

    @Test
    void testFindByIdNotFound() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        Book findResult = bookRepository.findById(66);
        assertNull(findResult);
    }

    @Test
    void testFindAllByAuthorIfAuthorCorrect() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        List <Book> bookList = bookRepository.findAllByAuthor(books.get(1).getAuthor());
        assertEquals(1, bookList.size());
    }

    @Test
    void testFindAllByAuthorIfAuthorIncorrect() {
        for (Book book : books) {
            bookRepository.save(book);
        }

        List <Book> bookList = bookRepository.findAllByAuthor("Sutarjo");
        assertTrue(bookList.isEmpty());
    }
}