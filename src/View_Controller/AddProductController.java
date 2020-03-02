package View_Controller;

import Model.Inventory;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class AddProductController {
    @FXML
    Button btnCancel;
    @FXML
    Label productId;
    @FXML
    TextField addName;
    @FXML
    TextField addInv;
    @FXML
    TextField addPrice;
    @FXML
    TextField addMin;
    @FXML
    TextField addMax;
    @FXML
    Button btnSearch;
    @FXML
    TextField searchField;
    @FXML
    TableView tableAssociatedProducts;
    @FXML
    Button btnAdd;
    @FXML
    TableView tableParts;
    @FXML
    Button btnDelete;
    @FXML
    Button btnSave;
    @FXML
    TableColumn partIdColumn;
    @FXML
    TableColumn partNameColumn;
    @FXML
    TableColumn partInvColumn;
    @FXML
    TableColumn partPriceColumn;


    Product newProduct;
    int index = Inventory.partsList.size() + 1;


    public AddProductController() {
    }

    @FXML
    public void clickBtnAdd(ActionEvent actionEvent) {


    }

    @FXML
    public void clickBtnSearch(ActionEvent actionEvent) {
        //todo
    }

    @FXML
    public void clickBtnSave(ActionEvent actionEvent) throws IOException {
        String name = addName.getText();
        int inv = Integer.valueOf(addInv.getText());
        Double price = Double.valueOf(addPrice.getText());
        int min = Integer.valueOf(addMin.getText());
        int max = Integer.valueOf(addMax.getText());

        newProduct = new Product(index,name,price,inv,min,max );
        Inventory.addProduct(newProduct);
        goToMainScreen();

    }

    @FXML
    public void clickBtnDelete(ActionEvent actionEvent) {
        //todo
    }

    public void goToMainScreen() throws IOException {
        MainScreenController mainScreenController = new MainScreenController();
        mainScreenController.goToMainStage();
    }

    @FXML
    public void clickBtnCancel(ActionEvent actionEvent) throws IOException {
        goToMainScreen();
    }

}
