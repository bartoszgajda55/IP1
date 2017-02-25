/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LoginController implements Initializable {

    @FXML
    private Label messageLabel;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private void login(ActionEvent event) {
        System.out.println(emailField.getText());
        System.out.println(passwordField.getText());
    }
    
    @FXML
    private void register(ActionEvent event) {
        messageLabel.setText("This is your warning!");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
