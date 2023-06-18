package phonebook;

public class Contact {
    private  String ID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String phoneNumber, String email, String ID) {
        setContactDetails(firstName, lastName, phoneNumber, email, ID);
    }

    private void setContactDetails(String firstName, String lastName, String phoneNumber, String email, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ID = ID;
    }

    public String displayContactDetails() {
        return String.format("""
                %s %s
                %s
                %s
                """, firstName, lastName, phoneNumber, email);
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return firstName +" "+ lastName;
    }

    public void editFirstNameN(String firstName) {
        this.firstName = firstName;
    }

    public void editLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String displayContactDetailsForSearch() {
        return String.format("""
                %s %s
                %s
                """, firstName, lastName, phoneNumber);
    }

    public void editPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
