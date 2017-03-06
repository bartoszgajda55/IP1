/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Models;

/**
 *
 * @author Admin
 */
public class BookEntity {
    
    private String title;
    private String category;
    private String author;
    private int isbn;
    private String publisher;
    private String date;
    private int pages;
    private int quantity;
    
    public BookEntity() {}
    
    public BookEntity(String title, String category, String author, int isbn, String publisher, String date, int pages, int quantity) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.date = date;
        this.pages = pages;
        this.quantity = quantity;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public int getIsbn() {
        return this.isbn;
    }
    
    public String getPublisher() {
        return this.publisher;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public int getPages() {
        return this.pages;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
}
