package phonebook;

import java.util.*;

public class PhoneBook {

    private List<Contact> contactObjectList = new ArrayList<>();
    private List<String> contactDisplayList = new ArrayList<>();

    public void addContact(String firstName, String lastName, String phoneNumber, String email) {
        Contact contact = new Contact(firstName, lastName, phoneNumber, email);
        contactObjectList.add(contact);
        contactDisplayList.add(firstName + " " + lastName);
    }

    public int getNumberOfContactsInPhoneBook() {
        return contactObjectList.size();
    }

    public String displayContactList() {
        Collections.sort(contactDisplayList);
        StringBuilder contactList = new StringBuilder();
        for(String contact : contactDisplayList){
            contactList.append(contact).append("\n");
        }
        return String.valueOf(contactList);
    }

    public void deleteContactByName(String contactName) {
        for (Contact contact : contactObjectList){
            boolean contactNameMatchesGivenName = Objects.equals(contactName, contact.toString());
            if (contactNameMatchesGivenName){
                contactObjectList.remove(contact);
                contactDisplayList.remove(contactName);
            }
        }
    }

    public String selectContactByName(String contactName) {
        for (Contact contact : contactObjectList) {
            boolean contactNameMatchesGivenName = Objects.equals(contactName, contact.toString());
            if (contactNameMatchesGivenName){
                return contact.selectedContactDetails();
            }
        }
        return null;
    }
}
