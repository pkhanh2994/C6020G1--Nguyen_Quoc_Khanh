package com.codegym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book")
public class Book {
    @Id
    private String idBook;
    private String bookName;
    private Integer quantity;
    private String author;

    public Book() {
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
