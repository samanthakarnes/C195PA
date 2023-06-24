package DAO;

import Model.Customers;
import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersDB {
    public boolean act;

    //uses search field to run a SQL select query
    public static Customers getCustomer(String customerName) throws SQLException, Exception {

        JDBC.getConnection();
        String sqlStatement = "select * FROM users WHERE User_name = '" + customerName + "'";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while (result.next()) {
            int customerID = result.getInt("Customer_ID");
            String resultName = result.getString("Customer_Name");
            String address = result.getString("Address");
            String postalCode = result.getString("Postal_Code");
            String phone = result.getString("Phone");
            int divisionID = result.getInt("Division_ID");
            Customers customerResult = new Customers(customerID, resultName, address, postalCode, phone, divisionID);
            return customerResult;
        }
        return null;
    }

    public static ObservableList<Customers> getallCustomers() throws SQLException, Exception {

        ObservableList<Customers> customersList = FXCollections.observableArrayList();
        JDBC.getConnection();
        String sqlStatment = "select * FROM customers";
        Query.makeQuery(sqlStatment);
        ResultSet result = Query.getResult();
        while (result.next()) {
            int customerID = result.getInt("Customer_ID");
            String resultName = result.getString("Customer_Name");
            String address = result.getString("Address");
            String postalCode = result.getString("Postal_Code");
            String phone = result.getString("Phone");
            int divisionID = result.getInt("Division_ID");
            Customers customerResult = new Customers(customerID, resultName, address, postalCode, phone, divisionID);
            customersList.add(customerResult);
        }
        return customersList;
    }

























    public static int insert(/** list params here **/) throws SQLException {
        String sql = "INSERT INTO customers (column names from db) VALUES(?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        //40 mins into JDBC webinar) ps.set the type of param ps.setString(1, customerName) etc
        //do this for each param matching sql types to java types (index #, param name)
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

}
