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
    private int book_id;
    private String title;
    private String category;
    private String author;
    private int isbn;
    private String publisher;
    private Date date;
    private Date return_date;
    private int fee_applied;
    
    public BorrowedBookEntity() {}
    
    public BorrowedBookEntity(int id, int user_id, int book_id, String title, String category, String author, int isbn, String publisher, Date date, Date return_date, int fee_applied) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.date = date;
        this.return_date = return_date;
        this.fee_applied = fee_applied;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }
    
    /**
     * @return the book_id
     */
    public int getBook_id() {
        return book_id;
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
     * @return the return_date
     */
    public Date getReturn_date() {
        return return_date;
    }
    
    /**
     * @return the fee_applied
     */
    public int getFee_applied() {
        return fee_applied;
    }
    
}
