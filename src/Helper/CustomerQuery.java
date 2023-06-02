package Helper;

import Model.Customers;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract public class CustomerQuery {

    public static int insert(/** list params here **/) throws SQLException {
        String sql = "INSERT INTO customers (column names from db) VALUES(?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        //40 mins into JDBC webinar) ps.set the type of param ps.setString(1, customerName) etc
        //do this for each param matching sql types to java types (index #, param name)
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

}
