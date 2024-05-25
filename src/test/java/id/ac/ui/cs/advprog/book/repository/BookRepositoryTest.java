package id.ac.ui.cs.advprog.book.repository;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.model.BookBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    BookBuilder bookBuilder = new BookBuilder();

    Book book1;
    Book book2;

    Date date1 = new Date();
    Date date2 = new Date();

    @BeforeEach
    void setUp() {
        book1 = bookBuilder.setIdBook(1)
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

//    @Test
//    void testFindBookById() {
//        bookRepository.save(book1);
//        Optional<Book> foundBook = bookRepository.findBookByIdBook(1);
//        assertTrue(foundBook.isPresent());
//        assertEquals(book1.getIdBook(), foundBook.get().getIdBook());
//    }

//    @Test
//    void testFindAllBooks() {
//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        List<Book> foundBooks = bookRepository.findAll();
//        assertEquals(2, foundBooks.size());
//    }
//
//    @Test
//    void testFindByAuthor() {
//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        List<Book> foundBooks = bookRepository.findByAuthor("Arthur Conan Doyle");
//        assertEquals(1, foundBooks.size());
//        assertEquals(book2.getAuthor(), foundBooks.getFirst().getAuthor());
//    }
}