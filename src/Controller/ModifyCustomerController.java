package Controller;

import DAO.CountryDB;
import DAO.CustomerDB;
import DAO.DivisionDB;
import Model.Country;
import Model.Customer;
import Model.Division;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     * Populates the text fields with a customer, selected by the user, passed from the customer table view
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param rb  The resources used to localize the root object, or null if the root object was not localized.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //add lists to combo boxes
        try {
            divisionComboBox.setItems(DivisionDB.getAllDivisions());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            countryComboBox.setItems(CountryDB.getAllCountries());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //populate fields with data selected from Customer Table View

        IDTextBox.setText(String.valueOf(customer.getCustomerID()));
        nameTextBox.setText(String.valueOf(customer.getCustomerName()));
        addressTextBox.setText(String.valueOf(customer.getAddress()));
        postTextBox.setText(String.valueOf(customer.getPostalCode()));
        phoneTextBox.setText(String.valueOf(customer.getPhoneNumber()));
        try {
            countryComboBox.setValue(CountryDB.getCountryFromDivisionID(customer.getDivisionID()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            divisionComboBox.setValue(DivisionDB.getDivisionNameQuery(customer.getDivisionID()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**A member used for importing the user-selected customer*/
    private static Customer customer = null;
    /**JavaFX stage*/
    Stage stage;
    /**JavaFX scene*/
    Parent scene;

    /**Receives the customer to be modified from the selected/highlighted row in the CustomerTableView screen.
     * This method is called in the CustomerTableViewController when the modify button is pressed.
     *
     * @param customerToModify The customer received from the user selection
     */
    public static void passCustomer (Customer customerToModify){
        customer = customerToModify;
    }

    @FXML
    private Label IDLabel;

    @FXML
    private TextField IDTextBox;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextBox;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<Country> countryComboBox;

    @FXML
    private Label countryLabel;

    @FXML
    private ComboBox<Division> divisionComboBox;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextBox;

    @FXML
    private Label phoneLabel;

    @FXML
    private TextField phoneTextBox;

    @FXML
    private Label postCodeLabel;

    @FXML
    private TextField postTextBox;

    @FXML
    private Button saveButton;

    @FXML
    void onActionBackToCustView(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerTableView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSaveAddCustomer(ActionEvent event) throws IOException {

        try{

            int customerID = Integer.parseInt(IDTextBox.getText());
            String name = nameTextBox.getText();
            String address = addressTextBox.getText();
            String postalCode = postTextBox.getText();
            String phoneNumber = phoneTextBox.getText();
            int divisionID = divisionComboBox.getValue().getDivisionID();

            //TODO Fix modifycustomer method
            //run a prepared statement
            int rowsAffected = CustomerDB.modifyCustomer(customerID, name, address, postalCode, phoneNumber, divisionID);

            //TODO add a "Customer added!" notification
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Updating customer in the database!");
            alert.show();

        }
        catch (Exception e) {
            System.out.println("Error message: " + e);
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerTableView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
}
