package id.ac.ui.cs.advprog.book.service;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBook() {
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.saveBook(book);

        assertEquals(book, savedBook);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testGetBookById() {
        int idBook = 1;
        Book book = new Book();
        book.setIdBook(idBook);
        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById(idBook);

        assertEquals(Optional.of(book), foundBook);
        verify(bookRepository, times(1)).findBookByIdBook(idBook);
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> foundBooks = bookService.getAllBooks();

        assertEquals(books.size(), foundBooks.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testDeleteBook() {
        int idBook = 1;
        Book book = new Book();
        book.setIdBook(idBook);
        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.of(book));

        bookService.deleteBook(idBook);

        verify(bookRepository, times(1)).delete(book);
    }

    @Test
    void testGetBooksByAuthor() {
        String author = "Test Author";
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookRepository.findByAuthor(author)).thenReturn(books);

        List<Book> foundBooks = bookService.getBooksByAuthor(author);

        assertEquals(books.size(), foundBooks.size());
        verify(bookRepository, times(1)).findByAuthor(author);
    }
}
