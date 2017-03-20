/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.RequestedBook;
import callib.Models.RequestedBookEntity;
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
public class RequestedDetailsController implements Initializable {

    private int requestId;
    private Stage stage;
    private RequestedBookEntity requestedDetails = null;
    private RequestedBook requested = RequestedBook.getInstance();
    
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
    private Button borrow;
    @FXML
    private Button cancel;
    
    @FXML
    private void borrowBook(ActionEvent event) {
        
    }
    
    @FXML
    private void cancelRequest(ActionEvent event) {
        
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
        borrow.setDisable(true);
    }
}
