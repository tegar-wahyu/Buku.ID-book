package id.ac.ui.cs.advprog.book.repository;

import id.ac.ui.cs.advprog.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findBookByIdBook(int idBook);
    List<Book> findByAuthor(String author);
}