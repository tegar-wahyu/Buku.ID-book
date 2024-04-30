package id.ac.ui.cs.advprog.book.controller;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBook() {
        Book book = new Book();
        when(bookService.saveBook(book)).thenReturn(book);

        ResponseEntity<Book> responseEntity = bookController.saveBook(book);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(book, responseEntity.getBody());
        verify(bookService, times(1)).saveBook(book);
    }

    @Test
    void testGetBookById_WhenBookExists() {
        int idBook = 1;
        Book book = new Book();
        book.setIdBook(idBook);
        when(bookService.getBookById(idBook)).thenReturn(Optional.of(book));

        ResponseEntity<Book> responseEntity = bookController.getBookById(idBook);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(book, responseEntity.getBody());
    }

    @Test
    void testGetBookById_WhenBookNotExists() {
        int idBook = 1;
        when(bookService.getBookById(idBook)).thenReturn(Optional.empty());

        ResponseEntity<Book> responseEntity = bookController.getBookById(idBook);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookService.getAllBooks()).thenReturn(books);

        ResponseEntity<List<Book>> responseEntity = bookController.getAllBooks();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(books, responseEntity.getBody());
    }

    @Test
    void testDeleteBook() {
        int idBook = 1;
        ResponseEntity<Void> responseEntity = bookController.deleteBook(idBook);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(bookService, times(1)).deleteBook(idBook);
    }

    @Test
    void testGetBooksByAuthor() {
        String author = "Test Author";
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookService.getBooksByAuthor(author)).thenReturn(books);

        ResponseEntity<List<Book>> responseEntity = bookController.getBooksByAuthor(author);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(books, responseEntity.getBody());
    }
}
