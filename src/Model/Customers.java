package Model;

import Helper.DateAndTimeProcessing;

public class Customers extends DateAndTimeProcessing {
    int customerID; //private key in DB
    String customerName;
    String address;
    String postalCode;
    String phoneNumber;
    int divisionID; //foreign key in DB

}
