/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.Book;
import callib.Models.BookEntity;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField search_field;
    @FXML
    private ComboBox search_combo;
    
    @FXML
    private TableView<BookEntity> table;    
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
    
    @FXML
    private void search(ActionEvent event) {
        System.out.println(search_combo.getValue());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<BookEntity> data = book.getBookList();
        
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        pages.setCellValueFactory(new PropertyValueFactory<>("pages"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
 
        table.setItems(data);
        
        ObservableList<String> options = FXCollections.observableArrayList("Title", "Category", "Author", "Publisher");
        search_combo.setItems(options);
    }    
    
}
