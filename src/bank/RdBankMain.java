package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RdBankMain {
    private static Scanner input = new Scanner(System.in);
    private  static RdBank rdBank = new RdBank();
    private static final int ZERO = 0;
    private static String menuOptionSelectionByUser;

    public static void main(String[] args) {
        String welcome = """
                *****************************************
                *****************************************
                
                            Welcome to RD Bank
                          
                *****************************************
                *****************************************
                """;
        display(welcome);
        mainMenu();
    }

    private static void mainMenu() {
        String displayMainMenu = """
                             ** MAIN MENU **
                1 ->> Register a new account with RD Bank.
                2 ->> Deposit.
                3 ->> Withdraw.
                4 ->> Transfer.
                5 ->> Check your account balance.
                6 ->> Exit application.
                """;

        menuOptionSelectionByUser = takeStringInput(displayMainMenu);
        switch (menuOptionSelectionByUser.charAt(ZERO)){
            case '1' -> registerAccount();
            case '2' -> deposit();
            case '3' -> withdraw();
            case '4' -> transfer();
            case '5' -> checkAccountBalance();
            case '6' -> exitApplication();
            default -> mainMenu();

        }

    }

    private static void checkAccountBalance() {
        String accountNumber = takeStringInput("Enter you account number: ");
        String pin = takeStringInput("Enter your pin: ");
        try{
            display(rdBank.checkAndAccountDetails( accountNumber, pin));
        }catch (IllegalArgumentException exception){
            display(exception.getMessage());
        }

        String checkAccountBalancePrompt = """
                            MENU
                1 ->> Return to main menu.
                2 ->> Check account balance.
                3 ->> Exit application.
                """;
        menuOptionSelectionByUser = takeStringInput(checkAccountBalancePrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)) {
            case '1' -> {mainMenu();}
            case '2' -> checkAccountBalance();
            case '3' -> exitApplication();
            default -> mainMenu();
        }
    }

    private static void transfer() {
        String senderAccountNumber = takeStringInput("Enter sender's account number: ");
        String pin = takeStringInput("Enter your pin: ");
        int transferAmount = Integer.parseInt(takeStringInput("Enter transfer amount: "));
        String receiverAccountNumber = takeStringInput("Enter receiver's account number: ");

        try{
            rdBank.transfer(senderAccountNumber, pin, transferAmount, receiverAccountNumber);
            display("** Transaction successful **");
        }catch (IllegalArgumentException exception){
            display(exception.getMessage());
            display("** Transaction unsuccessful **");
        }

        String transferPrompt = """
                            MENU
                1 ->> Return to main menu.
                2 ->> Perform transfer again.
                3 ->> Check account balance.
                4 ->> Exit application
                """;
        menuOptionSelectionByUser = takeStringInput(transferPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)) {
            case '1' -> {mainMenu();}
            case '2' -> transfer();
            case '3' -> checkAccountBalance();
            case '4' -> exitApplication();
            default -> mainMenu();
        }
    }

    private static void withdraw() {
        String accountNumber = takeStringInput("Enter your account number: ");
        String pin = takeStringInput("Enter your pin: ");
        int withdrawalAmount  = takeIntegerInput("Enter withdrawal amount: ");

        try {
            rdBank.withdraw(accountNumber, pin, withdrawalAmount);
            display("** Transaction successful. **\n");
        }catch (IllegalArgumentException exception){
            display(exception.getMessage());
            display("** Transaction unsuccessful. **\n");
        }

        String withdrawPrompt = """
                                 MENU
                1 ->> Return to main menu.
                2->> Perform withdrawal transaction again.
                3 ->> Check account balance.
                4 ->> Exit application.
                """;
        menuOptionSelectionByUser = takeStringInput(withdrawPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)){
            case '1' -> { mainMenu();}
            case '2' -> withdraw();
            case '3' -> checkAccountBalance();
            case '4' -> exitApplication();
            default -> mainMenu();
        }
    }

    private static void deposit() {
        String accountNumber = takeStringInput("Enter your account number: ");
        int depositAmount  = takeIntegerInput("Enter amount to be deposited: ");

        try {
            rdBank.deposit(accountNumber, depositAmount);
            display("** Transaction successful. **");
        }catch (IllegalArgumentException exception){
            display(exception.getMessage());
            display("** Transaction unsuccessful. **");
        }

        String depositPrompt = """
                                MENU
                1 ->> Return to main menu.
                2 ->> Perform deposit transaction again.
                3 ->> Check account balance.
                4 ->> Exit application.
                """;
        menuOptionSelectionByUser = takeStringInput(depositPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)){
            case '1' -> { mainMenu();}
            case '2' -> checkAccountBalance();
            case '3' -> deposit();
            case '4'-> exitApplication();
            default -> mainMenu();
        }

    }

    private static void registerAccount() {
        String firstName = takeStringInput("Enter your first name: ");
        String secondName = takeStringInput("Enter your second name: ");
        String pin = takeStringInput("Enter a four digit security pin: ");
        int initialDepositAmountIntegerValue = takeIntegerInput("Enter an initial deposit amount: ");
        String phoneNumber = takeStringInput("Enter you phone Number: ");

        String registeredAccountNumberDisplay = String.format("""
                %n
                **********************************************
                **********************************************
                         Registration was successful.
                         Here is your account number:
                                  %s
                Please keep this and your transaction pin safe
                    as you will require them for subsequent
                                transactions.
                **********************************************
                **********************************************
                %n
                """, rdBank.accountNumberGenerator(phoneNumber));

        try {
            rdBank.registerNewCustomer(firstName, secondName, pin, initialDepositAmountIntegerValue, phoneNumber);
            display(registeredAccountNumberDisplay);
        }catch (IllegalArgumentException exception){
            display(exception.getMessage());
            display("""
                    ********************************
                    ********************************
                    Registration was not successful.
                    ********************************
                    ********************************
                    """);
        }
        String displayPrompt = """
                                     MENU
                1 ->> Return to main menu.
                2 ->> Register a new account with RD Bank again.
                3 ->> Exit application.
                """;
        menuOptionSelectionByUser = takeStringInput(displayPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)) {
            case '1' -> { mainMenu();}
            case '2' -> registerAccount();
            case '3' -> exitApplication();
            default -> mainMenu();

        }
    }

    private static int takeIntegerInput(String prompt) {
        display(prompt);
        String errorMessage = "Your input is not valid. Please enter numbers";
        try {
            return input.nextInt();
        }catch (InputMismatchException exception){
            display(errorMessage);
            input.nextLine();
            return takeIntegerInput(prompt);
        }
    }

    private static String takeStringInput(String prompt) {
        display(prompt);
        return input.next();
    }

    private static void display(String message) {
        System.out.println(message);
    }

    private static void exitApplication() {
        String exitMessage = """
                ******************************
                ******************************
                Thank you for banking with us.
                          ** Bye **
                ******************************
                ******************************
                """;
        display(exitMessage);
        System.exit(0);
    }
}
