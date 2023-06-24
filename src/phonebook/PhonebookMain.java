package phonebook;

import java.util.Scanner;

public class PhonebookMain {
    private static Phonebook phonebook;
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        createAPhonebook();
    }

    private static void createAPhonebook() {
        String signupPrompt = """
                *****************************************************
                *****************************************************
                                    ** Welcome **
                *****************************************************
                *****************************************************
                
                1 ->> Create a password and user name for your phonebook.
                2 ->> Exit the phonebook application.
                """;

        String menuSelected = takeInput(signupPrompt);
        switch (menuSelected.charAt(0)){
            case '1' -> createLogInCredentials();
            case '2' -> exitApplication();
            default -> createAPhonebook();
        }
    }

    private static void createLogInCredentials() {
        displayMessage("** To Create your personal phone book **");
        String username = takeInput("Please Enter you phonebook username: ");
        String password = takeInput("Please Enter you phonebook password: ");
        phonebook = new Phonebook(username, password);
        phonebookMainMenu();
    }

    private static void phonebookMainMenu(){
        String mainMenuPrompts = """
                *****************************************************
                *****************************************************
                                 ** Phonebook Menu **
                                       
                *****************************************************
                *****************************************************
                1 ->> View Contacts.
                2 ->> Create a contact.
                3 ->> Search for a contact.
                4 ->> Exit the phonebook application.
                """;

        String menuSelected = takeInput(mainMenuPrompts).toUpperCase();

        switch (menuSelected.charAt(0)){
            case '1' -> viewContacts();
            case '2' -> createContact();
            case '3' -> searchContactList();
            case '4' -> exitApplication();
            default -> phonebookMainMenu();
        }
    }

    private static void viewContacts() {
        String mainMenuPrompts = String.format("""
                *****************************************************
                *****************************************************
                                  ** Contacts **
                                        %s
                *****************************************************
                *****************************************************
                                To select a contact,
                      press a contact serial number as appeared.
                B ->> Phonebook main menu.
                E ->> Exit the phonebook application.
                
                %s
                """, phonebook.getNumberOfContactsInPhonebook(), phonebook.displayContactList());


        String menuSelected = takeInput(mainMenuPrompts).toUpperCase();
        switch (menuSelected.charAt(0)){
            case 'B' -> phonebookMainMenu();
            case 'E' -> exitApplication();
            default -> {
                try {
                    validateInput(menuSelected);
                    displaySelectedContactFromList(Integer.parseInt(menuSelected));
                }catch (IllegalArgumentException exception){
                    displayMessage(exception.getMessage());
                    viewContacts();
                }
            }
        }
    }

    private static void createContact() {
        String firstName = takeInput("Please enter your first name: ");
        String lastName = takeInput("Please enter your last name: ");
        String phoneNumber = takeInput("Please enter your phone number: ");
        String email = takeInput("Please enter your email: ");
        phonebook.addContact(firstName, lastName, phoneNumber, email);
        displayMessage("** Contact successfully created **");
        viewContacts();
    }

    private static void validateInput(String menuSelected) {
        try {
            Integer.parseInt(menuSelected);
        }catch (IllegalArgumentException exception){
            displayMessage("** Please select the right option **");
            viewContacts();
        }
    }

    private static void displaySelectedContactFromList(int selectedSerialNumber) {

        displayMessage(phonebook.displaySelectedContact(selectedSerialNumber));
        String displayedContactMenu = """
                1 ->> Edit contact.
                2 ->> Delete contact.
                3 ->> View contacts.
                4 ->> Phonebook main menu.
                5 ->> Exit the phonebook application.
                """;
        String menuSelected = takeInput(displayedContactMenu).toUpperCase();
        switch (menuSelected.charAt(0)){
            case '1' -> editContact(selectedSerialNumber);
            case '2' -> {
                phonebook.deleteSelectedContact(selectedSerialNumber);
                viewContacts();
            }
            case '3' -> {viewContacts();}
            case '4' -> phonebookMainMenu();
            case '5' -> exitApplication();
            default -> displaySelectedContactFromList(selectedSerialNumber);
        }

    }

    private static void editContact(int selectedSerialNumber) {
        String editContactMenu = """
                1 ->> Edit first name.
                2 ->> Edit last name.
                3 ->> Edit phone number.
                4 ->> Main menu
                5 ->> Exit the phonebook application.
                """;
        String menuSelected = takeInput(editContactMenu).toUpperCase();
        switch (menuSelected.charAt(0)){
            case '1' -> editFirstNameOfContact(selectedSerialNumber);
            case '2' -> editLastNameOfContact(selectedSerialNumber);
            case '3' -> editPhoneNumberOfContact(selectedSerialNumber);
            case '4' -> {phonebookMainMenu();}
            case '5' -> exitApplication();
            default -> phonebookMainMenu();
        }
    }

    private static void editPhoneNumberOfContact(int selectedSerialNumber) {
        String phoneNumber = takeInput("Please enter new phone number: ");
        phonebook.editPhoneNumberOfSelectedContact(selectedSerialNumber, phoneNumber);
    }

    private static void editLastNameOfContact(int selectedSerialNumber) {
        String lastName = takeInput("Please enter new last name: ");
        phonebook.editLastNameOfSelectedContact(selectedSerialNumber, lastName);
    }

    private static void editFirstNameOfContact(int selectedSerialNumber) {
        String firstName = takeInput("Please enter new first name: ");
        phonebook.editFirstNameOfSelectedContact(selectedSerialNumber, firstName);

    }

    private static void searchContactList() {
        String nameToSearch = takeInput("Please Enter the name to search: ");
        String searchMenuDisplay = String.format("""
                *****************************************************
                *****************************************************
                                ** Searched Contacts **
                *****************************************************
                *****************************************************
                
                ->>>>           To select a contact,
                      press a contact serial number as appeared.
                S ->> Search again.
                B ->> View contacts.
                M ->> Phonebook main menu.
                E ->> Exit the phonebook application.
                
                %s
                """, phonebook.search(nameToSearch));

        String menuSelected = takeInput(searchMenuDisplay);

        menuSelected = menuSelected.toUpperCase();
        switch (menuSelected.charAt(0)){
            case 's' -> searchContactList();
            case 'B' -> viewContacts();
            case 'M' -> {phonebookMainMenu();}
            case 'E' -> exitApplication();
            default -> phonebookMainMenu();
        }
    }



    private static void exitApplication() {
        if (phonebook != null) phonebook.lockPhonebook();
        displayMessage("""
                *****************************************************
                *****************************************************
                                    ** Goodbye **
                *****************************************************
                *****************************************************
                """);
        System.exit(0);
    }

    private static String takeInput(String signupPrompt) {
        displayMessage(signupPrompt);
        return userInput.next();
    }

    private static void displayMessage(String message) {
        System.out.println(message);
    }
}

