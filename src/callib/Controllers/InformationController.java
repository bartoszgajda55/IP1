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
import javafx.stage.Stage;
import callib.Models.User;
import callib.Models.UserEntity;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class InformationController implements Initializable {
    
    private Stage stage;
    private Parent root;
    private User user = User.getInstance();
    
    @FXML
    private Label label;
    @FXML
    private Label id;
    @FXML
    private Label f_name;
    @FXML
    private Label l_name;
    @FXML
    private Label email;
    @FXML
    private Label course;
    @FXML
    private Label balance;
    
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
        UserEntity userInfo = user.getUserInfo(Main.getId());
        id.setText(Integer.toString(userInfo.getId()));
        f_name.setText(userInfo.getFirst_name());
        l_name.setText(userInfo.getLast_name());
        email.setText(userInfo.getEmail());
        course.setText(userInfo.getCourse());
        balance.setText(Double.toString(userInfo.getBalance()));
    }        
}
