package id.ac.ui.cs.advprog.book.service;

import id.ac.ui.cs.advprog.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    public Book saveBook(Book book);

    public Optional<Book> getBookById(int idBook);

    public List<Book> getAllBooks();

    public void deleteBook(int idBook);

    public List<Book> getBooksByAuthor(String author);
}