package Model;

public class Division {

    private int divisionID;
    private String divisionName;
    private int countryID;

    public Division(int divisionID, String divisionName, int countryID) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
    }

    //setters
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    //getters
    public int getDivisionID() {
        return divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public int getCountryID() {
        return countryID;
    }

    //Override toString method for combobox
    @Override
    public String toString() {
        return ("#" + Integer.toString(divisionID) + " - " +divisionName);
    }


}
