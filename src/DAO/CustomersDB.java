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

    //uses Query class
    public static ObservableList<Customers> getallCustomers() throws SQLException, Exception {

        ObservableList<Customers> customersList = FXCollections.observableArrayList();
        JDBC.getConnection();
        String sqlStatement = "select * FROM customers";
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
            customersList.add(customerResult);
        }
        return customersList;
    }

    /**public static ObservableList<Customers> getAllCustomers() {
        ObservableList<Customers> cusList = FXCollections.observableArrayList();

        try {
            //my SQL statement
            String sql = "SELECT Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID FROM customers";

            //create a prepared statement
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            //execute the query and get results
            ResultSet result = ps.executeQuery();
            //work through the results and add to the ObservableList
            while (result.next()) {
                int customerID = result.getInt("Customer_ID");
                String resultName = result.getString("Customer_Name");
                String address = result.getString("Address");
                String postalCode = result.getString("Postal_Code");
                String phone = result.getString("Phone");
                int divisionID = result.getInt("Division_ID");
                Customers customerResult = new Customers(customerID, resultName, address, postalCode, phone, divisionID);
                cusList.add(customerResult);
            }
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cusList;
    } **/



    public static int insert(/** list params here **/) throws SQLException {
        String sql = "INSERT INTO customers (column names from db) VALUES(?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        //40 mins into JDBC webinar) ps.set the type of param ps.setString(1, customerName) etc
        //do this for each param matching sql types to java types (index #, param name)
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

}
