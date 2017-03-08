/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SettingsController implements Initializable {

    private Stage stage;
    private Parent root;
    private User user = User.getInstance();
    
    @FXML
    private Label label;
    @FXML
    private Label warning;
    @FXML
    private PasswordField current_password;
    @FXML
    private PasswordField new_password;
    @FXML
    private PasswordField retype_password;
    
    @FXML
    private void changePassword(ActionEvent event) {
        warning.setTextFill(Color.web("#FF0000"));
        warning.setText("");
        boolean isValid = true;
        
        if(current_password.getText().equals("") || new_password.getText().equals("") || retype_password.getText().equals("")) {
            warning.setText("Field(s) empty!");
            isValid = false;
        } else if (!new_password.getText().equals(retype_password.getText())) {
            warning.setText("Passwords don't match!");
            isValid = false;
        } else if(current_password.getText().equals(new_password.getText())) {
            warning.setText("New password equals old one!");
            isValid = false;
        }
        
        if(isValid) {
            if(user.updatePassword(current_password.getText(),new_password.getText())) {
                warning.setTextFill(Color.web("#00FF00"));
                warning.setText("Password Changed");
            } else {
                warning.setText("Current password is not correct!");
            }
        }
    }
    
    @FXML
    private void back(ActionEvent event) throws IOException {
        stage = (Stage) label.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Dashboard.fxml"));
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
