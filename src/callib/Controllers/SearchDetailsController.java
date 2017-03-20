/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.Book;
import callib.Models.BookEntity;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SearchDetailsController implements Initializable {

    private Stage stage;
    private int bookId;
    private Book book = Book.getInstance();
    private BookEntity bookDetails = null;
    
    @FXML
    private Label label;
    @FXML
    private Label title;
    @FXML
    private Label category;
    @FXML
    private Label author;
    @FXML
    private Label isbn;
    @FXML
    private Label publisher;
    @FXML
    private Label date;
    @FXML
    private Label pages;
    @FXML
    private Label quantity;
    @FXML
    private Label warning;
    @FXML
    private Button borrow;
    @FXML
    private Button request;
    
    @FXML
    private void borrowBook(ActionEvent event) {
        System.out.println("borrow book");
    }
    
    @FXML
    private void requestBook(ActionEvent event) {
        System.out.println("request book");
    }
    
    @FXML
    private void close(ActionEvent event) {
        stage = (Stage) label.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initData(int id) {
        this.bookId = id;
        this.displayData();
        this.isBorrowAllowed();
    }
    
    private void isBorrowAllowed() {
        if(bookDetails.getQuantity() > 0)
            request.setDisable(true);
        else
            borrow.setDisable(true);
    }
    
    private void displayData() {
        bookDetails = book.getBookDetails(this.bookId);
        title.setText(bookDetails.getTitle());
        category.setText(bookDetails.getCategory());
        author.setText(bookDetails.getAuthor());
        isbn.setText(Integer.toString(bookDetails.getIsbn()));
        publisher.setText(bookDetails.getPublisher());
        date.setText(bookDetails.getDate().toString());
        pages.setText(Integer.toString(bookDetails.getPages()));
        quantity.setText(Integer.toString(bookDetails.getQuantity()));
    }
}
