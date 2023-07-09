package DAO;

import Model.Country;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CountryDB {

    public static ObservableList<Country> getAllCountries() throws SQLException, Exception{

        ObservableList<Country> countryList = FXCollections.observableArrayList();

        JDBC.getConnection();
        String sqlStatement = "select * FROM countries";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while (result.next()) {
            int countryID = result.getInt("Country_ID");
            String country = result.getString("Country");

           Country countryResult = new Country(countryID, country);
            countryList.add(countryResult);
        }

        return countryList;

    }

    //List of Strings of just country names for Combo box in add customer screen
    //not sure if needed anymore
    public static ObservableList<String> getCountryNames() throws SQLException, Exception {
        ObservableList<String> countryList = FXCollections.observableArrayList();

        JDBC.getConnection();
        String sqlStatement = "select country FROM countries";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while (result.next()) {

            String country = result.getString("Country");

            countryList.add(country);
        }

        return countryList;
    }

    //Joins the country and division ID tables in order to get the country name from the provided division ID
    public static Country getCountryFromDivisionID(int divisionID) throws SQLException, Exception {

        JDBC.getConnection();
        String sqlStmt = "select first_level_divisions.Division_ID, first_level_divisions.Country_ID, countries.Country"
                + " FROM first_level_divisions INNER JOIN countries"
                + " ON first_level_divisions.Country_ID=countries.Country_ID;";
        Query.makeQuery(sqlStmt);
        ResultSet result = Query.getResult();
        while(result.next()){
            if (divisionID == result.getInt("Division_ID")) {
                int countryID = result.getInt("Country_ID");
                String countryName = result.getString("Country");
                Country country = new Country(countryID, countryName);
                return country;
            }
        }
        return null;
    }

}
