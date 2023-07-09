package Controller;

import DAO.CustomerDB;
import Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;


public class CustomerTableViewController implements Initializable {

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            customerTableView.setItems(CustomerDB.getAllCustomers());
        } catch (Exception e) {
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
    private TableColumn<Customer, String> customerAddressCol;

    @FXML
    private TableColumn<Customer, Integer> customerDivisionIDCol;

    @FXML
    private TableColumn<Customer, Integer> customerIDCol;

    @FXML
    private Label customerLabel;

    @FXML
    private TableColumn<Customer, String> customerNameCol;

    @FXML
    private TableColumn<Customer, String> customerPhoneCol;

    @FXML
    private TableColumn<Customer, String> customerPostalCodeCol;

    @FXML
    private TextField customerSearch;

    @FXML
    private TableView<Customer> customerTableView;

    @FXML
    private Button deleteCustomerButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button modifyCustomerButton;

    //sends user to add customer screen
    @FXML
    void onActionAddCustomer(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddCustomer.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    //goes back to the NavScreen
    @FXML
    void onActionBackButton(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/NavScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeleteCustomer(ActionEvent event) throws Exception {

        //take a selected customer
        Customer custToRemove = customerTableView.getSelectionModel().getSelectedItem();

        //check for null values
        if (custToRemove == null) {
            alertToSend(5);
        }

        //check to see if customer has appointments. If they do customer cannot be deleted
        //TODO write appointment check


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete customer");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            while (custToRemove != null) {

                int wasDeleted = CustomerDB.deleteCustomer(custToRemove.getCustomerName());

                if (wasDeleted == 1){
                    alertToSend(3);
                    customerTableView.setItems(CustomerDB.getAllCustomers());
                    break;
                }

                else{
                    alertToSend(4);
                    break;
                }


            }
        }





    }

    //closes application
    @FXML
    void onActionExitButton(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit application");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        }

    }

    /*Take the highlighted customer and open it in the ModifyCustomer screen*/
    @FXML
    void onActionModifyCustomer(ActionEvent event) throws IOException {

        //Take the highlighted customer
        Customer customerToModify = customerTableView.getSelectionModel().getSelectedItem();

        //throws alert if there is no customer selected
        if (customerToModify == null) {
            alertToSend(1);
        } else {

            //pass it to new controller
            ModifyCustomerController.passCustomer(customerToModify);

            //open in ModifyCustomer screen
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/ModifyCustomer.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @FXML
    void onActionSearchCustomer(ActionEvent event) {
        //TODO does it need to search?
    }

    @FXML
    void partSearchUpdate(KeyEvent event) {
        //TODO does it need to search?
    }

    private void alertToSend(int alertType) {

        Alert alertError = new Alert(Alert.AlertType.ERROR);
        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);

        switch (alertType) {

            case 1:
                alertInformation.setTitle("Error");
                alertInformation.setHeaderText("Please select a customer to modify first");
                alertInformation.showAndWait();
                break;

            case 2:
                alertInformation.setTitle("Success!");
                alertInformation.setHeaderText("Modification successful");
                alertInformation.show();
                break;

            case 3:
                alertInformation.setTitle("Success!");
                alertInformation.setHeaderText("Delete successful");
                alertInformation.show();
                break;

            case 4:
                alertError.setTitle("Error");
                alertError.setHeaderText("Something went wrong. Customer could not be deleted");
                alertError.show();
                break;

            case 5:
                alertError.setTitle("Error");
                alertError.setHeaderText("Please select a customer to delete first");
                alertError.show();
                break;


        }
    }
}

