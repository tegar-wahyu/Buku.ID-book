package id.ac.ui.cs.advprog.book.repository;

import id.ac.ui.cs.advprog.book.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findBookByIdBook(int idBook);
    List<Book> findByAuthor(String author);
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.stock = b.stock - 1 WHERE b.idBook = :idBook AND b.stock > 0")
    int decrementStockByIdBook(int idBook);
}