/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callib.Controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class Main extends Application {
    
    private static int userId;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/callib/Views/Login.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            primaryStage.setScene(home_page_scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void setId(int id) {
        Main.userId = id;
    }
    
    public static int getId() {
        return Main.userId;
    }
    
}
