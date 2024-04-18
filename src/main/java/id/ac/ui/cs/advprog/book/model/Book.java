package id.ac.ui.cs.advprog.book.model;

import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Getter @Setter
public class Book {
    private int idBook;
    private String title;
    private String author;
    private String publisher;
    private float price;
    private int stock;
    private String isbn;
    private String bookPict;
    private Date publishDate;
    private String category;
    private int page;
    private String desc;

    Book(BookBuilder builder) {
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
}