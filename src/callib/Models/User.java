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
    
    public ArrayList<String> getUserInfo(int id) {
        try {
            ResultSet rs = connector.executeSelectStatement("SELECT * FROM users WHERE users.id LIKE " + id);
            if(rs.isBeforeFirst()) {
                rs.first();
                ArrayList alist = new ArrayList();
                alist.add(Integer.toString(rs.getInt("id")));
                alist.add(rs.getString("first_name"));
                alist.add(rs.getString("last_name"));
                alist.add(rs.getString("email"));
                alist.add(rs.getString("course"));
                return alist;
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
}
