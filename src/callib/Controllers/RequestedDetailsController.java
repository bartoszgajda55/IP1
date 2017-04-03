/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.Book;
import callib.Models.BorrowedBook;
import callib.Models.RequestedBook;
import callib.Models.RequestedBookEntity;
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
public class RequestedDetailsController implements Initializable {

    private int requestId;
    private Stage stage;
    
    private RequestedBookEntity requestedDetails = null;
    
    private RequestedBook requested = RequestedBook.getInstance();
    private Book book = Book.getInstance();
    private BorrowedBook borrowed = BorrowedBook.getInstance();
    
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
    private Label warning;
    @FXML
    private Button borrow;
    @FXML
    private Button cancel;
    
    @FXML
    private void borrowBook(ActionEvent event) {
        LocalDate today = LocalDate.now();
        LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);
        
        requested.deleteBookRequest(this.requestId);
        book.updateBookQuantity(requestedDetails.getBook_id(), -1);
        borrowed.addNewBorrowedBook(Main.getId(), requestedDetails.getBook_id(), today.toString(), next2Week.toString());
        
        this.close(event);
    }
    
    @FXML
    private void cancelRequest(ActionEvent event) {
        if(requested.deleteBookRequest(this.requestId)) {
            this.close(event);
        } else {
            warning.setTextFill(Color.web("#FF0000"));
            warning.setText("Error when canceling request!");
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
        this.requestId = id;
        this.displayData();
        this.isBorrowAllowed();
    }
    
    private void displayData() {
        requestedDetails = requested.getRequestedBookDetails(requestId);
        title.setText(requestedDetails.getTitle());
        category.setText(requestedDetails.getCategory());
        author.setText(requestedDetails.getAuthor());
        isbn.setText(Integer.toString(requestedDetails.getIsbn()));
        publisher.setText(requestedDetails.getPublisher());
        date.setText(requestedDetails.getDate().toString());
    }
    
    public void isBorrowAllowed() {
        if(book.getBookQuantity(requestedDetails.getBook_id()) > 0) {
            warning.setTextFill(Color.web("#00FF00"));
            warning.setText("Book is available!");
        } else {
            borrow.setDisable(true);
        }
    }
}
