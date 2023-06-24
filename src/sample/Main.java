package sample;

import DAO.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void init(){
        System.out.println("Application starting!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/LoginScreen.fxml"));
        primaryStage.setTitle("Scheduling Application");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //Locale locale = Locale.getDefault();
        //System.out.println(locale.getDisplayCountry());

        //sets locale to french for testing
        //Locale.setDefault(new Locale("fr"));
        JDBC.openConnection();

        launch(args);

        JDBC.closeConnection();
    }

    public void stop(){
        System.out.println("Application closed!");
    }
}
