package Controller;

import DAO.CustomersDB;
import Model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CustomerTableViewController implements Initializable {

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            customerTableView.setItems(CustomersDB.getallCustomers());
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }

        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        customerDivisionIDCol.setCellValueFactory(new PropertyValueFactory<>("divisionID"));
        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        customerPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
    }


    @FXML
    private Button addCustomerButton;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Customers, String> customerAddressCol;

    @FXML
    private TableColumn<Customers, Integer> customerDivisionIDCol;

    @FXML
    private TableColumn<Customers, Integer> customerIDCol;

    @FXML
    private Label customerLabel;

    @FXML
    private TableColumn<Customers, String> customerNameCol;

    @FXML
    private TableColumn<Customers, String> customerPhoneCol;

    @FXML
    private TableColumn<Customers, String> customerPostalCodeCol;

    @FXML
    private TextField customerSearch;

    @FXML
    private TableView<Customers> customerTableView;

    @FXML
    private Button deleteCustomerButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button modifyCustomerButton;

    @FXML
    void onActionAddCustomer(ActionEvent event) {

    }

    //goes back to the NavScreen
    @FXML
    void onActionBackButton(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/NavScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeleteCustomer(ActionEvent event) {


    }

    //closes application
    @FXML
    void onActionExitButton(ActionEvent event) throws IOException {
        //TODO add a warning or confirm prompt
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onActionModifyCustomer(ActionEvent event) {

    }

    @FXML
    void onActionSearchCustomer(ActionEvent event) {

    }

    @FXML
    void partSearchUpdate(KeyEvent event) {

    }

}

