/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
//import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SearchController implements Initializable {

    private Book book = Book.getInstance();
    private Stage stage;
    private Parent root;
    
    @FXML
    private TableView table;
    @FXML
    private TableColumn title;
    @FXML
    private TableColumn category;
    @FXML
    private TableColumn author;
    @FXML
    private TableColumn isbn;
    @FXML
    private TableColumn publisher;
    @FXML
    private TableColumn date;
    @FXML
    private TableColumn pages;
    @FXML
    private TableColumn quantity;
    @FXML
    private Label label;
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
        ObservableList<ArrayList> data = FXCollections.observableArrayList(book.getBookList());
//        title.setCellValueFactory(new PropertyValueFactory<ArrayList,String>());
//        table.setItems(data);
//        table.getColumns().addAll(title);
    }    
    
}
