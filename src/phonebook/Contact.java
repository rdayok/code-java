package phonebook;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String toString() {
        return firstName +" "+ lastName;
    }

    public String selectedContactDetails() {
        return String.format("""
                %s %s
                %s
                %s
                """, firstName, lastName, phoneNumber, email);
    }
}
