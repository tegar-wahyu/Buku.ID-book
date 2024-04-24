package id.ac.ui.cs.advprog.book.repository;

import id.ac.ui.cs.advprog.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> bookData = new ArrayList<>();
    public Book save (Book book) { return null; }
    public Book findById (int id) { return null; }
    public List <Book> findAllByAuthor (String author) { return null; }
}