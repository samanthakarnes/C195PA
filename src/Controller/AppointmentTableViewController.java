package Controller;

import DAO.CustomerDB;
import Model.Appointment;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class AppointmentTableViewController implements Initializable {

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            //customerTableView.setItems(//TODO write the getAllAppointments);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        apptIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        apptDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        apptLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        apptContactCol.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        apptTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        apptStartCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        apptEndCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        custIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        userIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));

    }
    @FXML
    private Button addApptButton;

    @FXML
    private Label appointmentLabel;

    @FXML
    private TableColumn<Appointment, Integer> apptContactCol;

    @FXML
    private TableColumn<Appointment, String> apptDescCol;

    @FXML
    private TableColumn<Appointment, LocalDateTime> apptEndCol;

    @FXML
    private TableColumn<Appointment, Integer> apptIDCol;

    @FXML
    private TableColumn<Appointment, String> apptLocationCol;

    @FXML
    private TableColumn<Appointment, LocalDateTime> apptStartCol;

    @FXML
    private TableColumn<Appointment, String> apptTitleCol;

    @FXML
    private TableColumn<Appointment, String> apptTypeCol;

    @FXML
    private TableColumn<Appointment, Integer> custIDCol;

    @FXML
    private TableColumn<Appointment, Integer> userIDCol;

    @FXML
    private Button backButton;

    @FXML
    private TextField customerSearch;

    @FXML
    private TableView<?> customerTableView;

    @FXML
    private Button deleteApptButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button modApptButton;

    @FXML
    void onActionAddAppt(ActionEvent event) {

    }

    @FXML
    void onActionBackButton(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/NavScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDeleteAppt(ActionEvent event) {

    }

    @FXML
    void onActionExitButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit application");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    @FXML
    void onActionModifyAppt(ActionEvent event) {

    }

    @FXML
    void onActionSearchCustomer(ActionEvent event) {

    }

    @FXML
    void partSearchUpdate(KeyEvent event) {

    }

}
