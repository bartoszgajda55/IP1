/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Models;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class User {
    
    private DBConnector connector = DBConnector.getInstance();
    
    private static User user = new User();
    
    private User() {}
    
    public static User getInstance() {
        return user;
    }
    
    public boolean isLoginCorrect(String email, String password) {
        try {
            ResultSet rs = connector.executeReadOnly("SELECT * FROM users WHERE users.email LIKE " + "'" + email + "'");
            rs.first();
            return rs.getString("password").equals(password);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
