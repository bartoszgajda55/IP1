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
import callib.Models.User;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LoginController implements Initializable {

    private User user = User.getInstance();
    private Stage stage;
    private Parent root;
    
    @FXML
    private Label messageLabel;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        messageLabel.setText("");
        if(user.isLoginCorrect(emailField.getText(), passwordField.getText())) {
            user.setUserId(emailField.getText());
            stage = (Stage) emailField.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/callib/Views/Dashboard.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            messageLabel.setText("Email or password incorrect!");
        }
    }
    
    @FXML
    private void register(ActionEvent event) throws IOException {
        stage = (Stage) emailField.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
