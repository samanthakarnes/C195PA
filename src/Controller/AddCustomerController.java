package Controller;

import DAO.CountryDB;
import DAO.CustomerDB;
import DAO.DivisionDB;
import Model.Country;
import Model.Customer;
import Model.Division;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerController {

    public void initialize() throws Exception {

        countryComboBox.setItems(CountryDB.getAllCountries());
        divisionComboBox.setItems(DivisionDB.getAllDivisions());

    }

    Stage stage;
    Parent scene;

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
    void onActionCountryComboAction(ActionEvent event) throws Exception {

        if (countryComboBox.getValue().getCountryID() == 1){
            divisionComboBox.setItems(DivisionDB.getDivisionsInCountry(1));
        } else
        if (countryComboBox.getValue().getCountryID() == 2){
            divisionComboBox.setItems(DivisionDB.getDivisionsInCountry(2));
        } else
        if (countryComboBox.getValue().getCountryID() == 3){
            divisionComboBox.setItems(DivisionDB.getDivisionsInCountry(3));
        } else divisionComboBox.setItems(DivisionDB.getAllDivisions());

    }

    @FXML
    void onActionBackToCustView(ActionEvent event) throws IOException {

        //TODO add an "Are you sure?" prompt

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerTableView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionSaveAddCustomer(ActionEvent event) throws IOException {

        //takes info from the boxes and add it to the database
        try{

            String name = nameTextBox.getText();
            String address = addressTextBox.getText();
            String postalCode = postTextBox.getText();
            String phoneNumber = phoneTextBox.getText();
            int divisionID = divisionComboBox.getValue().getDivisionID();

            //verify information is valid?

            //run a prepared statement
            int rowsAffected = CustomerDB.insertCustomer(name, address, postalCode, phoneNumber, divisionID);

            //TODO add a "Customer added!" notification
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Adding " +rowsAffected + " customer to the database!");
            alert.show();


        }
        catch (Exception e) {
            System.out.println("Error message: " + e);
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerTableVIew.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }

}
