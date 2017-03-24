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
public class UserEntity {
    
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String course;
    private double balance;
    
    public UserEntity() { }
    
    public UserEntity(int id, String first_name, String last_name, String email, String password, String course, double balance) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.course = course;
        this.balance = balance;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
}
