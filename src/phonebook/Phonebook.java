package phonebook;

import java.util.*;

public class Phonebook {

    private final String phonebookUsername;
    private String phonebookPassword;
    private boolean isPhonebookUnlocked;
    private List<Contact> contactObjectList = new ArrayList<>();
    private List<String> listOfContactNameAndID = new ArrayList<>();
    private List<String> IDList = new ArrayList<>();
    private StringBuilder displayContactListString;
    private String ID = "";
    private int indexOfSearchedContacts;


    public Phonebook(String phonebookUserName, String phonebookPassword) {
        this.phonebookUsername = phonebookUserName;
        this.phonebookPassword = phonebookPassword;
        isPhonebookUnlocked = true;
    }

    public boolean isPhonebookUnlocked() {
        return isPhonebookUnlocked;
    }

    public void lockPhonebook() {
        isPhonebookUnlocked = false;
    }

    public void unlockPhonebook(String username, String password) {
        validateUsername(username);
        validatePassword(password);
        isPhonebookUnlocked = true;
    }

    private void validatePassword(String password) {
        boolean isPhonebookPasswordIncorrect = !(Objects.equals(this.phonebookPassword, password));
        if(isPhonebookPasswordIncorrect) throwIllegalArgumentException("** This Password is incorrect **");
    }

    private void validateUsername(String username) {
        boolean isPhonebookUsernameIncorrect = !(Objects.equals(this.phonebookUsername, username));
        if(isPhonebookUsernameIncorrect) throwIllegalArgumentException("** This phonebook user name is incorrect **");
    }

    private void throwIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    public void addContact(String firstName, String lastName, String phoneNumber, String email) {
        validatePhonebookAccess();
        generateContactID();
        Contact contact = new Contact(firstName, lastName, phoneNumber, email, ID);
        contactObjectList.add(contact);
        listOfContactNameAndID.add(firstName + " " + lastName + ID);
        sortContacts();
    }

    public String displayContactList() {
        validatePhonebookAccess();
        displayContactListString = new StringBuilder();
        for(String ID : IDList){
            displayContactListString.append(IDList.indexOf(ID)).append(" ").append(searchContactByID_forDisplayContactList(ID)).append("\n");
        }
        return String.valueOf(displayContactListString);
    }

    public int getNumberOfContactsInPhonebook() {
        validatePhonebookAccess();
        return contactObjectList.size();
    }

    public void deleteSelectedContact(int contactSerialNumber) {
        validatePhonebookAccess();
        contactObjectList.removeIf(contact -> Objects.equals(contact.getID(), IDList.get(contactSerialNumber)));
        listOfContactNameAndID.remove(contactSerialNumber);
        IDList.remove(contactSerialNumber);
    }

    public String search(String searchInput) {
        validatePhonebookAccess();
        displayContactListString = new StringBuilder();
        Contact contact;
        for (String ID : IDList) {
            contact = getContactObject(ID);
            concatenateDetailsOfFoundContactsWithSameSearchInput(searchInput, contact);
        }
        return String.valueOf(displayContactListString);
    }

    public String displaySelectedContact(int contactSerialNumber) {
        validateContactSerialNumber(contactSerialNumber);
        validatePhonebookAccess();
        Contact gottenContactObject = getContactObject(IDList.get(contactSerialNumber));
        return gottenContactObject.displayContactDetails();
    }

    private void validateContactSerialNumber(int contactSerialNumber) {
        boolean isSerialNumberValid = contactSerialNumber < listOfContactNameAndID.size() && contactSerialNumber >= 0;
        if (!isSerialNumberValid) throwIllegalArgumentException("** Please select a serial number tha matches a contact to view **");
    }

    public void editFirstNameOfSelectedContact(int contactSerialNumber, String firstName) {
        validatePhonebookAccess();
        Contact gottenContactObject = getContactObject(IDList.get(contactSerialNumber));
        gottenContactObject.editFirstNameN(firstName);
        addEditedContactNameAndIDToList(contactSerialNumber, gottenContactObject);
    }

    public void editLastNameOfSelectedContact(int contactSerialNumber, String lastName) {
        validatePhonebookAccess();
        Contact gottenContactObject = getContactObject(IDList.get(contactSerialNumber));
        gottenContactObject.editLastName(lastName);
        addEditedContactNameAndIDToList(contactSerialNumber, gottenContactObject);
    }

    public void editPhoneNumberOfSelectedContact(int contactSerialNumber, String phoneNumber) {
        validatePhonebookAccess();
        Contact gottenContactObject = getContactObject(IDList.get(contactSerialNumber));
        gottenContactObject.editPhoneNumber(phoneNumber);
    }

    private void generateContactID() {
        String alphaNumericString = "0123456789";
        Random random = new Random();
        for( int index = 0; index < 4; index++) {
            int num = random.nextInt(0, alphaNumericString.length());
            concatenate(alphaNumericString.charAt(num));
        }
        if(isIDNotUnique()) generateContactID();
    }

    private boolean isIDNotUnique() {
        for (String id : IDList) if (Objects.equals(id, ID)) return true;
        return false;
    }

    private String searchContactByID_forDisplayContactList(String ID) {
        for (Contact contact: contactObjectList) {
            if (Objects.equals(ID, contact.getID())) return contact.toString();
        }
        return null;
    }

    private void sortContacts() {
        ID = "";
        listOfContactNameAndID.sort(String.CASE_INSENSITIVE_ORDER);
        IDList.clear();
        for (String contactNameAndID : listOfContactNameAndID) {
            takeOutTheName(contactNameAndID);
        }
    }

    private void takeOutTheName(String contactNameAndID) {
        for (int index = contactNameAndID.length() - 4; index < contactNameAndID.length() ; index++){
            concatenate(contactNameAndID.charAt(index));
        }
        IDList.add(ID);
        ID = "";
    }

    private void concatenate(char selectedCharacter) {
        ID += selectedCharacter;
    }

    private void addEditedContactNameAndIDToList(int contactSerialNumber, Contact gottenContactObject) {
        String contactName = gottenContactObject.toString();
        String contactNameAndID = contactName + gottenContactObject.getID();
        listOfContactNameAndID.set(contactSerialNumber, contactNameAndID);
        sortContacts();
    }

    private void concatenateDetailsOfFoundContactsWithSameSearchInput(String searchInput, Contact contact) {
        boolean isInputSameWithAnyOfContactsDetails = searchInput.equalsIgnoreCase(contact.toString()) || searchInput.equalsIgnoreCase(contact.getFirstName())  || searchInput.equalsIgnoreCase(contact.getLastName()) || searchInput.equalsIgnoreCase(contact.getPhoneNumber());
        if (isInputSameWithAnyOfContactsDetails) displayContactListString.append(contact.displayContactDetailsForSearch());
    }

    private Contact getContactObject(String contactObjectID) {
        for (Contact contact: contactObjectList) {
            boolean isContactObjectWithTheID = Objects.equals(contactObjectID, contact.getID());
            if (isContactObjectWithTheID) return contact;
        }
        throw new Error("Glitch");
    }

    private void validatePhonebookAccess() {
        if(!isPhonebookUnlocked) throwIllegalArgumentException("** Phonebook is locked. Unlock to use **");
    }

    public String getUserName() {
        return phonebookUsername;
    }
}
