package Model;

public class Contact {

    private int contactID;
    private String name;
    private String email;

    public Contact(int contactID, String name, String email) {
        this.contactID = contactID;
        this.name = name;
        this.email = email;
    }

    //setters
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getters
    public int getContactID() {
        return contactID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
