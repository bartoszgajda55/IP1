/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Models;

import callib.Controllers.Main;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Admin
 */
public class BorrowedBook {
    
    private DBConnector connector = DBConnector.getInstance();
    
    private static BorrowedBook borrowed = new BorrowedBook();
    
    private BorrowedBook() {}
    
    public static BorrowedBook getInstance() {
        return borrowed;
    }
    
    public ObservableList<BorrowedBookEntity> getAllBorrowedBooksList() {
        ResultSet rs = connector.executeSelectStatement("SELECT borrowed_books.id, borrowed_books.date, borrowed_books.return_date, "
                + "borrowed_books.user_id, books.title, books.category, books.author, books.isbn, books.publisher FROM borrowed_books "
                + "INNER JOIN books ON borrowed_books.book_id = books.id WHERE borrowed_books.user_id LIKE " + Main.getId());
        try {
            ObservableList<BorrowedBookEntity> result = FXCollections.observableArrayList();
            while (rs.next()) {
                result.add(new BorrowedBookEntity(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("category"), rs.getString("author"), rs.getInt("isbn"), 
                    rs.getString("publisher"), rs.getDate("date"), rs.getDate("return_date")));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public BorrowedBookEntity getBorrowedBookDetails(int id) {
        try {
            ResultSet rs = connector.executeSelectStatement("SELECT borrowed_books.id, borrowed_books.date, borrowed_books.return_date, "
                + "borrowed_books.user_id, books.title, books.category, books.author, books.isbn, books.publisher FROM borrowed_books "
                + "INNER JOIN books ON borrowed_books.book_id = books.id WHERE borrowed_books.id LIKE " + id);
            if(rs.isBeforeFirst()) {
                rs.first();
                BorrowedBookEntity entity = new BorrowedBookEntity(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("category"), rs.getString("author"),
                    rs.getInt("isbn"), rs.getString("publisher"), rs.getDate("date"), rs.getDate("return_date"));
                return entity;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean updateReturnDate(int id, String date) {
        return connector.executeUpdateStatement("UPDATE borrowed_books SET return_date = '" + date + "' WHERE id LIKE " + id);
    }
}
