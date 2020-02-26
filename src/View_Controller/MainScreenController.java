package View_Controller;
// https://code.makery.ch/library/javafx-tutorial/part2/


import Kari_Cathey.Main;
import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML
    private Inventory inventory;
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
    static boolean entered;

    public MainScreenController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Add sample data for evaluation.

        if (!entered) {
            Product product1 = new Product(1, "Screws", 0.55, 55, 5, 5000);
            Product product2 = new Product(2, "Saws", 9.55, 55, 5, 5000);
            Product product3 = new Product(3, "Springs", 0.45, 155, 5, 500);
            Inventory.addProduct(product1);
            Inventory.addProduct(product2);
            Inventory.addProduct(product3);
            Part part1 = new Part(1, "Wrench", 10.99, 53, 5, 500);
            Part part2 = new Part(2, "Hammer", 10.99, 53, 5, 500);
            Part part3 = new Part(3, "Fishing Pole", 22.99, 53, 5, 550);
            Inventory.addPart(part1);
            Inventory.addPart(part2);
            Inventory.addPart(part3);
            entered = true;
        }

        tableParts.setItems(Inventory.getAllParts());
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableProducts.setItems(Inventory.getAllProducts());
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInvColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        /* partId.setCellValueFactory( cellData -> cellData.getValue().getIdProperty().asObject() );
        partName.setCellValueFactory( cellData -> cellData.getValue().getNameProperty() );  //string doesn't need asObject
        partInv.setCellValueFactory( cellData -> cellData.getValue().getInvProperty().asObject() );
        partPrice.setCellValueFactory( cellData -> cellData.getValue().getPriceProperty().asObject() );
        productId.setCellValueFactory( cellData -> cellData.getValue().getIdProperty().asObject() );
        productName.setCellValueFactory( cellData -> cellData.getValue().getNameProperty());  //string doesn't need asObject
        productInv.setCellValueFactory( cellData -> cellData.getValue().getInvProperty().asObject() );
        productPrice.setCellValueFactory( cellData -> cellData.getValue().getPriceProperty().asObject() );

         */
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
    } //fixme need to write

    @FXML
    public void clickPartDelete(ActionEvent e) {
    }  //fixme need to write

    @FXML
    void exitApp(ActionEvent event) {
        System.exit(0);
    }

}
