package id.ac.ui.cs.advprog.book.repository;

import id.ac.ui.cs.advprog.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> bookData = new ArrayList<>();
    public Book save (Book book) {
        int i = 0;
        for (Book savedBook : bookData) {
            if (savedBook.getIdBook() == book.getIdBook()) {
                bookData.remove(i);
                bookData.add(i, book);
                return book;
            }
            i++;
        }

        bookData.add(book);
        return book;
    }
    public Book findById (int id) {
        for (Book book : bookData) {
            if (book.getIdBook() == id) {
                return book;
            }
        }
        return null;
    }
    public List <Book> findAllByAuthor (String author) {
        List <Book> books = new ArrayList<>();
        for (Book book : bookData) {
            if (book.getAuthor().equals(author)) {
                books.add(book);
            }
        }
        return books;
    }
}