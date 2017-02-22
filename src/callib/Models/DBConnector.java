/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBConnector {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static final String CONN_STRING = "jdbc:mysql://localhost/callib?useUnicode=true&characterEncoding=UTF-8";
    private Connection conn = null;
    
    public DBConnector() {      
        try {
            this.conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Simple method for testing SQL statement execution on DB
     * 
     * @param String SqlQuery SQL query to be executed
     * @return void
     */
    public void executeStatement(String SqlQuery) {
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(SqlQuery);
        
            while(rs.next()) {
                StringBuilder buffer = new StringBuilder();
                
                buffer.append("User ").append(rs.getNString("first_name")).append(": ").append(rs.getNString("last_name"));
                System.out.println(buffer.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
