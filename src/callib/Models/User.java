/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Models;

/**
 *
 * @author Admin
 */
public class User {
    
    private static User user = new User();
    
    private User() {}
    
    public static User getInstance() {
        return user;
    }
}
