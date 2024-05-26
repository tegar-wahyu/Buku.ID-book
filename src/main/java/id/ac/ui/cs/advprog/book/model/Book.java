package id.ac.ui.cs.advprog.book.model;

import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book_app")
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "price")
    private float price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "book_pict")
    private String bookPict;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "category")
    private String category;

    @Column(name = "page")
    private int page;

    @Column(name = "description")
    private String desc;

    public Book(BookBuilder builder) {
        this.idBook = builder.getIdBook();
        this.title = builder.getTitle();
        this.author = builder.getAuthor();
        this.publisher = builder.getPublisher();
        this.price = builder.getPrice();
        this.stock = builder.getStock();
        this.isbn = builder.getIsbn();
        this.bookPict = builder.getBookPict();
        this.publishDate = builder.getPublishDate();
        this.category = builder.getCategory();
        this.page = builder.getPage();
        this.desc = builder.getDesc();
    }

    public Book() {}
}