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
public class BorrowedBookEntity {
    
    private int id;
    private int user_id;
    private String title;
    private String category;
    private String author;
    private int isbn;
    private String publisher;
    private Date date;
    private Date return_date;
    
    public BorrowedBookEntity() {}
    
    public BorrowedBookEntity(int id, int user_id, String title, String category, String author, int isbn, String publisher, Date date, Date return_date) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.date = date;
        this.return_date = return_date;
    }
    
    public int getId() {
        return id;
    }
    
    public int getUser_id() {
        return user_id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getIsbn() {
        return isbn;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public Date getDate() {
        return date;
    }
    
    public Date getReturn_date() {
        return return_date;
    }
    
}
