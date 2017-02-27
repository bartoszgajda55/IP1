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

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DashboardController implements Initializable {

    @FXML
    private Label label;
    private Stage stage = (Stage) label.getScene().getWindow();
    private Parent root;
    @FXML
    private void information(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Information.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void borrowed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Borrowed.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void requests(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Requests.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void settings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Settings.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void search(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Search.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/callib/Views/Login.fxml"));
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
