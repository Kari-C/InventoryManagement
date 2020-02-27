package View_Controller;

import Kari_Cathey.Main;
import Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.text.TabableView;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML
    private TableView<Part> tableParts;
    @FXML
    private TableView<Product> tableProducts;
    @FXML
    private TableColumn<Part, Integer> partIdColumn;
    @FXML
    private TableColumn<Part, String> partNameColumn;
    @FXML
    private TableColumn<Part, Integer> partInvColumn;
    @FXML
    private TableColumn<Part, Double> partPriceColumn;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Integer> productInvColumn;
    @FXML
    private TableColumn<Product, Double> productPriceColumn;
    @FXML
    private Button btnPartSearch;
    @FXML
    private Button btnProductSearch;
    @FXML
    private TextField partSearchField;
    @FXML
    private TextField productSearchField;

    public MainScreenController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        tableParts.setItems(Inventory.getAllParts());
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("id")); //'id' is the actual variable name
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableProducts.setItems(Inventory.getAllProducts());
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //testing output
        System.out.println(Inventory.getAllParts());
        System.out.println(Inventory.getAllProducts());
    }

    /*
    @FXML
    private void NextScreenHandler(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) Next.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader(getClass().getResource(
                "secondScreen.fxml"));
        root =loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        SecondScreenController controller = loader.getController();
        Person person=table.getSelectionModel().getSelectedItem();
        controller.setPerson(person);

        tableProducts.setItems(Inventory.productsList);
    }*/


    @FXML
    public void updatePartTableView() {
        tableParts.setItems(Inventory.getAllParts());
    }

    @FXML
    public void updateProductTableView() {
        tableProducts.setItems(Inventory.getAllProducts());
    }


    @FXML
    public void clickPartModify(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("ModifyPart.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 482, 480));
        primaryStage.show();

    }

    @FXML
    public void clickProductModify(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 800, 485));
        primaryStage.show();
    }

    @FXML
    public void clickPartAdd(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 482, 480));
        primaryStage.show();
    }

    @FXML
    public void clickProductAdd(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        Parent window = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(new Scene(window, 802, 480));
        primaryStage.show();
    }

    @FXML
    public void clickProductDelete(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete the product?");
        alert.setTitle("Delete Product?");  //message for window
        Optional<ButtonType> result = alert.showAndWait();  //confirmation window button
        if(result.isPresent() && result.get() == ButtonType.OK) {
            ObservableList<Product> allProducts, singleProduct;
            allProducts = tableProducts.getItems();  //gets the entire list of in table
            singleProduct = tableProducts.getSelectionModel().getSelectedItems();  //highlighted item assigned as single part
            singleProduct.forEach(allProducts::remove);  //removes the selected part
        }
    }

    @FXML
    public void clickPartDelete(ActionEvent e) {  //delete the selected part in the table and confirm choice
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete the part?");
        alert.setTitle("Delete Part?");  //message for window
        Optional<ButtonType> result = alert.showAndWait();  //confirmation window button
        if(result.isPresent() && result.get() == ButtonType.OK) {
            ObservableList<Part> allParts, singlePart;
            allParts = tableParts.getItems();  //gets the entire list of in table
            singlePart = tableParts.getSelectionModel().getSelectedItems();  //highlighted item assigned as single part
            singlePart.forEach(allParts::remove);  //removes the selected part
        }
    }

    @FXML  //this closes the program
    void exitApp(ActionEvent event) {
        System.exit(0);
    }

    public void clickPartSearch(ActionEvent actionEvent) {

        String search = partSearchField.getText();  //capture the text in the search field
        tableParts.getSelectionModel().select(Part.searchPart(search));

    }




    public void clickProductSearch(ActionEvent actionEvent) {
        //fixme need to write this
    }
}
