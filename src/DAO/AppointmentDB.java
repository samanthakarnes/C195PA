package DAO;

import Model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppointmentDB {

    public static ObservableList<Appointment> getAllAppointments() throws SQLException, Exception {

        ObservableList<Appointment> apptList = FXCollections.observableArrayList();

        JDBC.getConnection();
        String sqlStmt = "SELECT * FROM appointments";
        Query.makeQuery(sqlStmt);
        ResultSet result = Query.getResult();

        while (result.next()){

            int apptID = result.getInt("Appointment_ID");
            String title = result.getString("Title");
            String desc = result.getString("Description");
            String location = result.getString("Location");
            String type = result.getString("Type");
            LocalDateTime start = result.getDate("Start");
            LocalDateTime end = result.getObject("End", Appointment<LocalDateTime>);
            int custID = result.getInt("Customer_ID");
            int userID = result.getInt("User_ID");
            int contactID = result.getInt("Contact_ID");

            Appointment apptResult = new Appointment(apptID, title, desc, location, type, start, end, custID, userID, contactID);
            apptList.add(apptResult);

        }

        return apptList;
    }
}
