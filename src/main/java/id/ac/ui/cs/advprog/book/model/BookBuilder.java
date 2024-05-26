package id.ac.ui.cs.advprog.book.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class BookBuilder {
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

    public BookBuilder setIdBook(int id) {
        this.idBook = id;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public BookBuilder setPrice(float price) {
        this.price = price;
        return this;
    }

    public BookBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder setBookPict(String bookPict) {
        this.bookPict = bookPict;
        return this;
    }

    public BookBuilder setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public BookBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public BookBuilder setPage(int page) {
        this.page = page;
        return this;
    }

    public BookBuilder setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Book build() {
        // Validasi data-data yang diperlukan sebelum membuat objek Book
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author is required");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        return new Book(this);
    }
}