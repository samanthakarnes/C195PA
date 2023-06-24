package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CustomerTableViewController {

    @FXML
    private Button addCustomerButton;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> customerAddressCol;

    @FXML
    private TableColumn<?, ?> customerDivisionIDCol;

    @FXML
    private TableColumn<?, ?> customerIDCol;

    @FXML
    private Label customerLabel;

    @FXML
    private TableColumn<?, ?> customerNameCol;

    @FXML
    private TableColumn<?, ?> customerPhoneCol;

    @FXML
    private TableColumn<?, ?> customerPostalCodeCol;

    @FXML
    private TextField customerSearch;

    @FXML
    private TableView<?> customerTableView;

    @FXML
    private Button deleteCustomerButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button modifyCustomerButton;

    @FXML
    void onActionAddCustomer(ActionEvent event) {

    }

    @FXML
    void onActionBackButton(ActionEvent event) {

    }

    @FXML
    void onActionDeleteCustomer(ActionEvent event) {

    }

    @FXML
    void onActionExitButton(ActionEvent event) {

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

