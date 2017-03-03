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
            System.out.println(Main.getId());
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String[] getUserInfo(int id) {
        try {
            ResultSet rs = connector.executeSelectStatement("SELECT * FROM users WHERE users.id LIKE " + id);
            if(rs.isBeforeFirst()) {
                rs.first();
                String[] array = new String[5];
                array[0] = Integer.toString(rs.getInt("id"));
                array[1] = rs.getString("first_name");
                array[2] = rs.getString("last_name");
                array[3] = rs.getString("email");
                array[4] = rs.getString("course");
                return array;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
