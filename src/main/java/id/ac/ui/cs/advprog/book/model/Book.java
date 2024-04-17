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

    //title cannot be null
    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }
}