/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.RequestedBook;
import callib.Models.RequestedBookEntity;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class RequestedController implements Initializable {

    private RequestedBook requested = RequestedBook.getInstance();
    private Stage stage;
    private Parent root;
    
    @FXML
    private TableView<RequestedBookEntity> table;
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
    private void clickItem(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) {
            stage = (Stage) label.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/callib/Views/RequestedDetails.fxml"));
            Stage modal  = new Stage();
            modal.initModality(Modality.APPLICATION_MODAL);
            modal.setScene(
                    new Scene((Pane) loader.load())
            );
            modal.setX(stage.getX() + 50);
            modal.setY(stage.getY() + 50);
            RequestedDetailsController controller = (RequestedDetailsController) loader.getController();
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
        ObservableList<RequestedBookEntity> data = requested.getAllRequestedBooksList();
        
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
 
        table.setItems(data);
    }  
}
