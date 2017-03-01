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
            ResultSet rs = connector.executeSelectStatement("SELECT password FROM users WHERE users.email LIKE '" + email + "'");
            if(rs.isBeforeFirst()) {
                rs.first();
                return rs.getString("password").equals(password);
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean addUser(String first_name, String last_name, String email, String password, String course) {
        return connector.executeInsertStatement("INSERT INTO users (first_name, last_name, email, password, course) VALUES ('"+first_name+"','"+last_name+"','"+email+"','"+password+"','"+course+"')");
    }
}
