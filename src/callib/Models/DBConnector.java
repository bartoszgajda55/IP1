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
    private static DBConnector dbConnector = new DBConnector();
    
    public static DBConnector getInstance() {
        return dbConnector;
    } 
    
    private DBConnector() {      
        try {
            this.conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet executeReadOnly(String SqlQuery) {
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(SqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
