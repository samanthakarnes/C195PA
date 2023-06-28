package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Button exitButton;

    @FXML
    private Label locationField;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label passwordFieldLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextBox;

    @FXML
    void onExitButtonClicked(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onLoginButtonClicked(ActionEvent event) throws IOException {
        //TODO will verify login information to ensure access to db

        //right now this will just move to nav screen
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/NavScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //locationField.setText(Locale.getDefault().getDisplayCountry());
        String location = Locale.getDefault().getDisplayCountry();

        //This displayed MT
        //String zoneLocation = ZoneId.systemDefault().getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault());

        locationField.setText(location);
    }
}

