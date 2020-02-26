package Kari_Cathey;
// Kari Cathey Final Project - Inventory System
// Software I - C482

import Model.Part;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootlayout;

    public Main(){  //data for testing
        Product product1 = new Product(1,"Screws",0.55, 55, 5,5000);
        Product product2 = new Product(2,"Saws",9.55, 55, 5,5000);
        Product product3 = new Product(3,"Springs",0.45, 155, 5,500);
        Part part1 = new Part(1,"Wrench",10.99,53,5,500);
        Part part2 = new Part(2,"Hammer",10.99,53,5,500);
        Part part3 = new Part(3,"Fishing Pole",22.99,53,5,550);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inventory Management System");
        initRootLayout();

    }

    public void initRootLayout(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml")); // the '/' at beginning goes up one directory
            primaryStage.setScene(new Scene(root, 870, 510));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
