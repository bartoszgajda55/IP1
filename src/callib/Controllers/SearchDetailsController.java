/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.Book;
import callib.Models.BookEntity;
import callib.Models.BorrowedBook;
import callib.Models.RequestedBook;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
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
    private BorrowedBook borrowed = BorrowedBook.getInstance();
    private RequestedBook requested = RequestedBook.getInstance();
    
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
        if(borrowed.isBookBorrowedAlready(Main.getId(), this.bookId)) {
            LocalDate today = LocalDate.now();
            LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);

            borrowed.addNewBorrowedBook(Main.getId(), this.bookId, today.toString(), next2Week.toString());
            book.updateBookQuantity(this.bookId, -1);

            quantity.setText(Integer.toString(bookDetails.getQuantity() - 1));
            warning.setTextFill(Color.web("#00FF00"));
            warning.setText("Book successfully borrowed!");

            this.isBorrowOrRequestAllowed();
        } else {
            warning.setTextFill(Color.web("#FF0000"));
            warning.setText("Book borrowed already!");
        }
    }
    
    @FXML
    private void requestBook(ActionEvent event) {
        if(requested.isBookRequestedAlready(Main.getId(), this.bookId)) {
            LocalDate today = LocalDate.now();
            requested.addNewRequestedBook(Main.getId(), this.bookId, today.toString());
            warning.setTextFill(Color.web("#00FF00"));
            warning.setText("Book successfully requested!");
        } else {
            warning.setTextFill(Color.web("#FF0000"));
            warning.setText("Book requested already!");
        }
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
        this.isBorrowOrRequestAllowed();
    }
    
    private void isBorrowOrRequestAllowed() {
        if(bookDetails.getQuantity() > 0)
            request.setDisable(true);
        else {
            borrow.setDisable(true);
            warning.setTextFill(Color.web("#FF0000"));
            warning.setText("Book not available!");
        }
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
