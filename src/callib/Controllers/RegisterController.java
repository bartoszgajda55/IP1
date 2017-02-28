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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class RegisterController implements Initializable {

    private Stage stage;
    private Parent root;
    private User user = User.getInstance();
    
    @FXML
    private Label label;
    @FXML
    private Label first_warning;
    @FXML
    private Label last_warning;
    @FXML
    private Label email_warning;
    @FXML
    private Label password_warning;
    @FXML
    private Label r_password_warning;
    @FXML
    private Label course_warning;
    @FXML
    private TextField first_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField email;
    @FXML
    private TextField course;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField r_password;
    @FXML
    private void back(ActionEvent event) throws IOException {
        stage = (Stage) label.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void register(ActionEvent event) throws IOException {
        first_warning.setText("");
        last_warning.setText("");
        email_warning.setText("");
        password_warning.setText("");
        course_warning.setText("");
        boolean isValid = true;

        if(first_name.getText().equals("")) {
            first_warning.setText("Field empty!");
            isValid = false;
        }
        if(last_name.getText().equals("")) {
            last_warning.setText("Field empty!");
            isValid = false;
        }
        if(email.getText().equals("")) {
            email_warning.setText("Field empty!");
            isValid = false;
        }
        if(password.getText().equals("")) {
            password_warning.setText("Field empty!");
            isValid = false;
        }
        if(r_password.getText().equals("")) {
            r_password_warning.setText("Field empty!");
            isValid = false;
        }
        if(!password.getText().equals(r_password.getText())) {
            password_warning.setText("Passwords are not matching!");
            r_password_warning.setText("");
            isValid = false;
        }
        if(course.getText().equals("")) {
            course_warning.setText("Field empty!");
            isValid = false;
        }
        
        if(isValid) {
            if(user.addUser(first_name.getText(), last_name.getText(), email.getText(), password.getText(), course.getText())) {
                stage = (Stage) label.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/callib/Views/Dashboard.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
