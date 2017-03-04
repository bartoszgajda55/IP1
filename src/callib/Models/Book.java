/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Book {
    
    private DBConnector connector = DBConnector.getInstance();
    
    private static Book book = new Book();
    
    private Book() {}
    
    public static Book getInstance() {
        return book;
    }
    
    public ArrayList<ArrayList<String>> getBookList() {
        ResultSet rs = connector.executeSelectStatement("SELECT * FROM books");
        int numcols;
        try {
            numcols = rs.getMetaData().getColumnCount();
            ArrayList<ArrayList<String>> result = new ArrayList<>();

            while (rs.next()) {
                ArrayList<String> row = new ArrayList<>(numcols); // new list per row

                for (int i=1; i<= numcols; i++) {  // don't skip the last column, use <=
                    row.add(rs.getString(i));
                    System.out.print(rs.getString(i) + "\t");
                }
                result.add(row); // add it to the result
                System.out.print("\n");
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }
}
