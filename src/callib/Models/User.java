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
import callib.Controllers.Main;
import java.util.ArrayList;
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
    
    public void setUserId(String email) {
        ResultSet rs = connector.executeSelectStatement("SELECT id FROM users WHERE users.email LIKE '" + email + "'");
        try {
            rs.first();
            Main.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public UserEntity getUserInfo(int id) {
        try {
            ResultSet rs = connector.executeSelectStatement("SELECT * FROM users WHERE users.id LIKE " + id);
            if(rs.isBeforeFirst()) {
                rs.first();
                return new UserEntity(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"),
                        rs.getString("course"), rs.getDouble("balance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean updatePassword(String oldPassword, String newPassword) {
        try {
            ResultSet rs = connector.executeSelectStatement("SELECT password FROM users WHERE users.id LIKE " + Main.getId());
            rs.first();
            if(!rs.getString("password").equals(oldPassword)) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connector.executeUpdateStatement("UPDATE users SET password = '" + newPassword + "' WHERE id LIKE " + Main.getId());
    }
    
    public boolean updateUserBalance(int userId, double balance) {
        return connector.executeUpdateStatement("UPDATE users SET balance = " + (this.getUserBalance(userId) + balance) + " WHERE id LIKE " + userId);
    }
    
    public double getUserBalance(int userId) {
        ResultSet rs = connector.executeSelectStatement("SELECT balance FROM users WHERE id LIKE " + userId);
        try {
            if(rs.isBeforeFirst()) {
                rs.first();
                return rs.getDouble("balance");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
