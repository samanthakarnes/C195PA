package DAO;

import Model.Customer;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DivisionDB {

    public static ObservableList<Division> getAllDivisions() throws SQLException, Exception{

        ObservableList<Division> divisionList = FXCollections.observableArrayList();

        JDBC.getConnection();
        String sqlStatement = "select * FROM first_level_divisions";
        Query.makeQuery(sqlStatement);
        ResultSet result = Query.getResult();
        while (result.next()) {
            int divisionID = result.getInt("Division_ID");
            String division = result.getString("Division");
            int countryID = result.getInt("Country_ID");

            Division divisionResult = new Division(divisionID, division, countryID);
            divisionList.add(divisionResult);
        }

        return divisionList;

    }

}
