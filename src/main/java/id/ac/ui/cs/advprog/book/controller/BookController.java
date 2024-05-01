package id.ac.ui.cs.advprog.book.controller;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int idBook) {
        Optional<Book> book = bookService.getBookById(idBook);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int idBook) {
        bookService.deleteBook(idBook);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("author") String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> editBook(@PathVariable("id") int idBook, @RequestBody Book updatedBook) {
        Book editedBook = bookService.editBook(idBook, updatedBook);
        if (editedBook != null) {
            return new ResponseEntity<>(editedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
