package Controller;

import DAO.CustomerDB;
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

    public void initialize(){
        divisionComboBox.getItems().addAll();
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
    private ComboBox<?> countryComboBox;

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
            int divisionID = divisionComboBox.getVisibleRowCount(); //maybe

            //verify information is valid?

            //run a prepared statement thingy
            int rowsAffected = CustomerDB.insertCustomer(name, address, postalCode, phoneNumber, divisionID);

            //TODO add a "Customer added!" notification
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Adding " +rowsAffected + "customer to the database!");
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
