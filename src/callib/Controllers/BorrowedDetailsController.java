/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.BorrowedBook;
import callib.Models.BorrowedBookEntity;
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
public class BorrowedDetailsController implements Initializable {

    
    private Stage stage;
    private int borrowkId;
    private BorrowedBook borrowed = BorrowedBook.getInstance();
    private BorrowedBookEntity bookDetails = null;
    
    
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
    private Label return_date;
    @FXML
    private Label warning;
    @FXML
    private Button extend;
    
    @FXML
    private void extendReturnTime(ActionEvent event) {
        LocalDate extendedDate = bookDetails.getReturn_date().toLocalDate().plus(2, ChronoUnit.WEEKS);
        if(borrowed.updateReturnDate(bookDetails.getId(), extendedDate.toString())) {
            extend.setDisable(true);
            return_date.setText(extendedDate.toString());
            warning.setTextFill(Color.web("#00FF00"));
            warning.setText("Extended Succefully!");
        } else {
            warning.setTextFill(Color.web("#FF0000"));
            warning.setText("Extension Failed!");
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
        //TODO
    }

    public void initData(int id) {
        this.borrowkId = id;
        this.displayData();
        this.isReturnExtensionAllowed();
    }
    
    private void displayData() {
        bookDetails = borrowed.getBorrowedBookDetails(this.borrowkId);
        title.setText(bookDetails.getTitle());
        category.setText(bookDetails.getCategory());
        author.setText(bookDetails.getAuthor());
        isbn.setText(Integer.toString(bookDetails.getIsbn()));
        publisher.setText(bookDetails.getPublisher());
        date.setText(bookDetails.getDate().toString());
        return_date.setText(bookDetails.getReturn_date().toString());
    }
    
    private void isReturnExtensionAllowed() {
        LocalDate today = LocalDate.now();
        LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);
        
        if(bookDetails.getReturn_date().toLocalDate().isBefore(today)) {
            extend.setDisable(true);
            warning.setTextFill(Color.web("#FF0000"));
            warning.setText("Return date has passed!");
        }
        else if(bookDetails.getReturn_date().toLocalDate().isAfter(next2Week)) {
            extend.setDisable(true);
            warning.setTextFill(Color.web("#FF0000"));
            warning.setText("Return date is longer than 2 weeks.");
        }
    }
    
}
