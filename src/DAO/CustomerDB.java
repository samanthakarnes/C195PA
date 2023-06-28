package DAO;

import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CustomerDB {
    public boolean act;

    //uses search field to run a SQL select query
    public static Customer getCustomer(String customerName) throws SQLException, Exception {

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
            Customer customerResult = new Customer(customerID, resultName, address, postalCode, phone, divisionID);
            return customerResult;
        }
        return null;
    }

    //uses Query class
    public static ObservableList<Customer> getallCustomers() throws SQLException, Exception {

        ObservableList<Customer> customerList = FXCollections.observableArrayList();
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
            Customer customerResult = new Customer(customerID, resultName, address, postalCode, phone, divisionID);
            customerList.add(customerResult);
        }
        return customerList;
    }

    /**public static ObservableList<Customer> getAllCustomers() {
        ObservableList<Customer> cusList = FXCollections.observableArrayList();

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
                Customer customerResult = new Customers(customerID, resultName, address, postalCode, phone, divisionID);
                cusList.add(customerResult);
            }
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return cusList;
    } **/



    public static int insertCustomer(String custName, String custAddress, String custPostCode, String custPhone, int divisionID) throws SQLException {

        String sql = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);

        ps.setString(1, custName);
        ps.setString(2, custAddress);
        ps.setString(3, custPostCode);
        ps.setString(4, custPhone);
        ps.setInt(5, divisionID);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

}
