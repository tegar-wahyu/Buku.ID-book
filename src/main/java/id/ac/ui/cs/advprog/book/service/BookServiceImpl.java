package id.ac.ui.cs.advprog.book.service;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.model.BookBuilder;
import id.ac.ui.cs.advprog.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(int idBook) {
        return bookRepository.findBookByIdBook(idBook);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(int idBook) {
        Optional<Book> book = bookRepository.findBookByIdBook(idBook);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Book editBook(int idBook, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findBookByIdBook(idBook);
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            BookBuilder bookBuilder = new BookBuilder()
                    .setIdBook(bookToUpdate.getIdBook())
                    .setTitle(updatedBook.getTitle())
                    .setAuthor(updatedBook.getAuthor())
                    .setPublisher(updatedBook.getPublisher())
                    .setPrice(updatedBook.getPrice())
                    .setStock(updatedBook.getStock())
                    .setIsbn(updatedBook.getIsbn())
                    .setBookPict(updatedBook.getBookPict())
                    .setPublishDate(updatedBook.getPublishDate())
                    .setCategory(updatedBook.getCategory())
                    .setPage(updatedBook.getPage())
                    .setDesc(updatedBook.getDesc());

            Book updatedBookObj = bookBuilder.build();
            return bookRepository.save(updatedBookObj);
        } else {
            return null;
        }
    }
}