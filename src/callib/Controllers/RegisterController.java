/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

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
    
    @FXML
    private Label label;
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
    private void register(ActionEvent event) {
        System.out.println(first_name.getText());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
