/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import callib.Models.BorrowedBookEntity;
import callib.Models.BorrowedBook;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BorrowedController implements Initializable {

    private BorrowedBook borrowed = BorrowedBook.getInstance();
    private Stage stage;
    private Parent root;
    
    @FXML
    private TableView<BorrowedBookEntity> table;
    @FXML
    private TableColumn<BorrowedBookEntity, String> title;
    @FXML
    private TableColumn<BorrowedBookEntity, String> category;
    @FXML
    private TableColumn<BorrowedBookEntity, String> author;
    @FXML
    private TableColumn<BorrowedBookEntity, Integer> isbn;
    @FXML
    private TableColumn<BorrowedBookEntity, String> publisher;
    @FXML
    private TableColumn<BorrowedBookEntity, Date> date;
    @FXML
    private TableColumn<BorrowedBookEntity, Date> return_date;
    
    @FXML
    public void clickItem(MouseEvent event) throws IOException
    {
        if (event.getClickCount() == 2) {
            stage = (Stage) label.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/callib/Views/BorrowedDetails.fxml"));
            Stage modal  = new Stage();
            modal.initModality(Modality.APPLICATION_MODAL);
            modal.setScene(
                    new Scene((Pane) loader.load())
            );
            modal.setX(stage.getX() + 50);
            modal.setY(stage.getY() + 50);
            BorrowedDetailsController controller = loader.<BorrowedDetailsController>getController();
            controller.initData(table.getSelectionModel().getSelectedItem().getId());
            
            modal.showAndWait();
        }
    }
    
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
        ObservableList<BorrowedBookEntity> data = borrowed.getAllBorrowedBooksList();
        
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        return_date.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        
        
//        return_date.setCellFactory((TableColumn<BorrowedBookEntity, Date> column) -> {
//            return new TableCell<BorrowedBookEntity, Date>() {
//                @Override
//                protected void updateItem(Date item, boolean empty) {
//                    super.updateItem(item, empty);
//                    setText(empty ? "" : "some date");
//                }
//            };
//        });
 
        table.setItems(data);
    }    
    
}
