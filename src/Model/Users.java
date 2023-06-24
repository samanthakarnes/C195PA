package Model;

import Helper.DateAndTimeProcessing;

public class Users extends DateAndTimeProcessing {

    private int userID;
    private String username;
    private String password;

    //constructor
    public Users(int userID,String username, String password){
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    //setters
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //gettters
    public int getUserID(){
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
