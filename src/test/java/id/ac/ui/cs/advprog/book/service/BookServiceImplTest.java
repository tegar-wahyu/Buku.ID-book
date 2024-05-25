package id.ac.ui.cs.advprog.book.service;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBook() {
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        CompletableFuture<Book> futureBook = bookServiceImpl.saveBook(book);
        Book savedBook = futureBook.join();

        assertEquals(book, savedBook);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testGetBookById_WhenBookExists() {
        int idBook = 1;
        Book book = new Book();
        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.of(book));

        CompletableFuture<Optional<Book>> futureBook = bookServiceImpl.getBookById(idBook);
        Optional<Book> foundBook = futureBook.join();

        assertTrue(foundBook.isPresent());
        assertEquals(book, foundBook.get());
        verify(bookRepository, times(1)).findBookByIdBook(idBook);
    }

    @Test
    void testGetBookById_WhenBookNotExists() {
        int idBook = 1;
        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.empty());

        CompletableFuture<Optional<Book>> futureBook = bookServiceImpl.getBookById(idBook);
        Optional<Book> foundBook = futureBook.join();

        assertFalse(foundBook.isPresent());
        verify(bookRepository, times(1)).findBookByIdBook(idBook);
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = List.of(new Book(), new Book());
        when(bookRepository.findAll()).thenReturn(books);

        CompletableFuture<List<Book>> futureBooks = bookServiceImpl.getAllBooks();
        List<Book> foundBooks = futureBooks.join();

        assertEquals(books, foundBooks);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testDeleteBook_WhenBookExists() {
        int idBook = 1;
        Book book = new Book();
        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.of(book));

        CompletableFuture<Void> futureVoid = bookServiceImpl.deleteBook(idBook);
        futureVoid.join();

        verify(bookRepository, times(1)).findBookByIdBook(idBook);
        verify(bookRepository, times(1)).delete(book);
    }

    @Test
    void testDeleteBook_WhenBookNotExists() {
        int idBook = 1;
        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.empty());

        CompletableFuture<Void> futureVoid = bookServiceImpl.deleteBook(idBook);

        assertThrows(CompletionException.class, futureVoid::join);

        verify(bookRepository, times(1)).findBookByIdBook(idBook);
        verify(bookRepository, times(0)).delete(any(Book.class));
    }


    @Test
    void testGetBooksByAuthor() {
        String author = "Test Author";
        List<Book> books = List.of(new Book(), new Book());
        when(bookRepository.findByAuthor(author)).thenReturn(books);

        CompletableFuture<List<Book>> futureBooks = bookServiceImpl.getBooksByAuthor(author);
        List<Book> foundBooks = futureBooks.join();

        assertEquals(books, foundBooks);
        verify(bookRepository, times(1)).findByAuthor(author);
    }

    @Test
    void testEditBook_WhenBookExists() {
        int idBook = 1;
        Book existingBook = new Book();
        existingBook.setIdBook(idBook);
        Book updatedBook = new Book();
        updatedBook.setTitle("Updated Title");
        updatedBook.setAuthor("Updated Author");
        updatedBook.setPrice(10.99f);

        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        CompletableFuture<Book> futureBook = bookServiceImpl.editBook(idBook, updatedBook);
        Book editedBook = futureBook.join();

        assertNotNull(editedBook);
        assertEquals(updatedBook.getTitle(), editedBook.getTitle());
        verify(bookRepository, times(1)).findBookByIdBook(idBook);
        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    void testEditBook_WhenBookNotExists() {
        int idBook = 1;
        Book updatedBook = new Book();
        when(bookRepository.findBookByIdBook(idBook)).thenReturn(Optional.empty());

        CompletableFuture<Book> futureBook = bookServiceImpl.editBook(idBook, updatedBook);
        Book editedBook = futureBook.join();

        assertNull(editedBook);
        verify(bookRepository, times(1)).findBookByIdBook(idBook);
        verify(bookRepository, times(0)).save(any(Book.class));
    }
}
