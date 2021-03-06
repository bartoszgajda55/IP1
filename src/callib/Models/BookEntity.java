/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Models;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BookEntity {
    
    private int id;
    private String title;
    private String category;
    private String author;
    private int isbn;
    private String publisher;
    private Date date;
    private int pages;
    private int quantity;
    
    public BookEntity() {}
    
    public BookEntity(int id, String title, String category, String author, int isbn, String publisher, Date date, int pages, int quantity) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.date = date;
        this.pages = pages;
        this.quantity = quantity;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
}
