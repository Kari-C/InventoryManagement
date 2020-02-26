package View_Controller;
// https://code.makery.ch/library/javafx-tutorial/part2/
// Uses observableList

import Model.Part;
import Model.Product;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainScreenController {
    @FXML
    private ObservableList<Part> partList = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Product> productList = FXCollections.observableArrayList();

    public MainScreenController() throws IOException {
    }

    public ObservableList<Part> getPartList() {
        return partList;
    }

    public ObservableList<Product> getProductList(){
        return productList;
    }

    public void clickPartModify(ActionEvent e) throws IOException{
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("ModifyPart.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 482, 480));
        primaryStage.show();

    }
    public void clickProductModify(ActionEvent e) throws IOException{
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 800, 485));
        primaryStage.show();

    }

    public void clickPartAdd(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 482, 480));
        primaryStage.show();
    }

    public void clickProductAdd(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 802, 480));
        primaryStage.show();
    }

    public void clickProductDelete(ActionEvent e){}

    public void clickPartDelete(ActionEvent e){}
}
