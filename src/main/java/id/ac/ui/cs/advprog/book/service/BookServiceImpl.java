package id.ac.ui.cs.advprog.book.service;

import id.ac.ui.cs.advprog.book.model.Book;
import id.ac.ui.cs.advprog.book.model.BookBuilder;
import id.ac.ui.cs.advprog.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Async
    public CompletableFuture<Book> saveBook(Book book) {
        return CompletableFuture.completedFuture(bookRepository.save(book));
    }

    @Override
    @Async
    public CompletableFuture<Optional<Book>> getBookById(int idBook) {
        return CompletableFuture.completedFuture(bookRepository.findBookByIdBook(idBook));
    }

    @Override
    @Async
    public CompletableFuture<List<Book>> getAllBooks() {
        return CompletableFuture.completedFuture(bookRepository.findAll());
    }

    @Override
    @Async
    public CompletableFuture<Void> deleteBook(int idBook) {
        Optional<Book> book = bookRepository.findBookByIdBook(idBook);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }
        return CompletableFuture.completedFuture(null);
    }

    @Override
    @Async
    public CompletableFuture<List<Book>> getBooksByAuthor(String author) {
        return CompletableFuture.completedFuture(bookRepository.findByAuthor(author));
    }

    @Override
    @Async
    public CompletableFuture<Book> editBook(int idBook, Book updatedBook) {
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
            return CompletableFuture.completedFuture(bookRepository.save(updatedBookObj));
        } else {
            return CompletableFuture.completedFuture(null);
        }
    }
}