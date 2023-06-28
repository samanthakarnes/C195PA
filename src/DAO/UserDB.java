package DAO;
///this will do CRUD on the users table

import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
    static boolean act;



    //READ operations
    //gets one user from a SQL statement
    public static Users getUser(String username) throws SQLException, Exception {
        JDBC.getConnection();
        String sqlStatement="select * FROM users WHERE User_name = '" +username+ "'";
        Query.makeQuery(sqlStatement);

        ResultSet result = Query.getResult();
        while(result.next()){
            int userID=result.getInt("User_ID");
            String resultUsername=result.getString("User_Name");
            String password = result.getString("Password");
            Users userResult = new Users(userID, resultUsername, password);
            return userResult;
        }
        return null;
    }

    //gets all users from SQL query
    public static ObservableList<Users> getAllUsers() throws SQLException, Exception{
        ObservableList<Users> allUsers = FXCollections.observableArrayList();
        JDBC.getConnection();
        String sqlStatment = "select * FROM users";
        Query.makeQuery(sqlStatment);
        ResultSet result = Query.getResult();
        while(result.next()){
            int userID = result.getInt("User_ID");
            String username = result.getString("User_Name");
            String password = result.getString("Password");
            Users userResult = new Users(userID, username, password);
            allUsers.add(userResult);
        }
        return allUsers;
    }

}
