package DAO;

import Model.Country;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DivisionDB {

    public static ObservableList<Division> getAllDivisions() throws SQLException, Exception{

        ObservableList<Division> allDivisionList = FXCollections.observableArrayList();

        JDBC.getConnection();
        String sqlStatement = "select * FROM first_level_divisions";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while (result.next()) {
            int divisionID = result.getInt("Division_ID");
            String division = result.getString("Division");
            int countryID = result.getInt("Country_ID");

            Division divisionResult = new Division(divisionID, division, countryID);
            allDivisionList.add(divisionResult);
        }

        return allDivisionList;

    }

    public static ObservableList<Division> getDivisionsInCountry(int ctryID) throws SQLException, Exception{

        ObservableList<Division> divList = FXCollections.observableArrayList();

        JDBC.getConnection();
        String sqlStmt = "SELECT * FROM first_level_divisions WHERE Country_ID = '" + ctryID +"'";
        Query.makeQuery(sqlStmt);
        ResultSet result = Query.getResult();
        while (result.next()){
            int divisionID = result.getInt("Division_ID");
            String division = result.getString("Division");
            int countryID = result.getInt("Country_ID");

            Division divisionResult = new Division(divisionID, division, countryID);
            divList.add(divisionResult);

        }
        return divList;
    }

    //list of strings not sure if needed anymore
    /**
    public static ObservableList<String> getDivisionList() throws SQLException, Exception {

        ObservableList<String> divisionList = FXCollections.observableArrayList();

        JDBC.getConnection();
        String sqlStmt = "SELECT division FROM first_level_divisions";
        Query.makeQuery(sqlStmt);
        ResultSet result = Query.getResult();
        while (result.next()){
            String division = result.getString("Division");
            divisionList.add(division);
        }

        return divisionList;
    } */

    public static Division getDivisionNameQuery(int divisionID) throws SQLException, Exception {

        JDBC.getConnection();
        String sqlStmt = "SELECT * FROM first_level_divisions";
        Query.makeQuery(sqlStmt);
        ResultSet result = Query.getResult();
        while(result.next()){
            if(divisionID == result.getInt("Division_ID")){
                String divisionName = result.getString("Division");
                int countryID = result.getInt("Country_ID");
                Division divisionResult = new Division(divisionID, divisionName, countryID);
                return divisionResult;
            }
        }
        return null;

    }


    public static int getDivisionIDFromName(String divisionName) throws SQLException, Exception {
        JDBC.getConnection();
        String sqlStmt = "SELECT * first_level_divisions";
        Query.makeQuery(sqlStmt);
        ResultSet result = Query.getResult();
        while(result.next()){
            if (divisionName.equals(result.getString("Division"))){
                return result.getInt("Division_ID");
            }
        }

        return 0;
    }

}
