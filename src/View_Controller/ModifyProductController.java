package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable{
    @FXML
    private TableView<Part> tableSearchProducts;
    @FXML
    private TableColumn<Part, Integer> addPartId;
    @FXML
    private TableColumn<Product, String> addPartName;
    @FXML
    private TableColumn<Product, Integer> addPartInv;
    @FXML
    private TableColumn<Product, Double> addPartPrice;
    @FXML
    private TableView<Part> associatedPartsTable;
    @FXML
    private TableColumn<Part, Integer> associatedId;
    @FXML
    private TableColumn<Product, String> associatedName;
    @FXML
    private TableColumn<Product, Integer> associatedInv;
    @FXML
    private TableColumn<Product, Double> associatedPrice;

    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnAdd;

    Product product;


    public ModifyProductController(){}

    @Override  //when you use this you need the 'Initializable' in the main part of class
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updatePartTable();

        addPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        addPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        addPartInv.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        addPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        product = new Product(0, null, 0.0, 0, 0, 0);
        associatedPartsTable.setItems((ObservableList<Part>) product.getAllAssociatedParts()); //cast is here kari

        associatedId.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedName.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedInv.setCellValueFactory(new PropertyValueFactory<>("inStock"));
        associatedPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    }


    public void updatePartTable() {
        tableSearchProducts.setItems(Inventory.getAllParts());

    }

}
