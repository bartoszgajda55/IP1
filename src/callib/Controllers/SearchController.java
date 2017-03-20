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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

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
        table.setItems(book.getFilteredBooksList(search_field.getText(), (String) search_combo.getValue()));
    }
    
    @FXML
    private void clickItem(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) {
            stage = (Stage) label.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/callib/Views/SearchDetails.fxml"));
            Stage modal  = new Stage();
            modal.initModality(Modality.APPLICATION_MODAL);
            modal.setScene(
                    new Scene((Pane) loader.load())
            );
            modal.setX(stage.getX() + 50);
            modal.setY(stage.getY() + 50);
            SearchDetailsController controller = (SearchDetailsController) loader.getController();
            controller.initData(table.getSelectionModel().getSelectedItem().getId());
            
            modal.showAndWait();
            this.displayData();
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.displayData();
    }
    
    private void displayData() {
        ObservableList<BookEntity> data = book.getAllBooksList();
        
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
        search_combo.getSelectionModel().selectFirst();
    }
}
