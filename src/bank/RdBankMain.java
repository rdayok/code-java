package bank;




import java.util.Scanner;

public class RdBankMain {
    private static Scanner input = new Scanner(System.in);
    private  static RdBank rdBank = new RdBank();
    private static int ZERO = 0;
    private static String userInput;

    public static void main(String[] args) {
        String welcome = String.format("""
                ***************************************
                ***************************************
                
                          Welcome to RD Bank!
                          
                ***************************************
                ***************************************
                """);
        display(welcome);
        mainMenu();
    }

    private static void mainMenu() {
        String displayMainMenu = """
                      
                1 ->> Register a new account with RD Bank.
                2 ->> Deposit
                3 ->> Withdraw
                4 ->> Transfer
                5 ->> Check your account balance
                6 ->> Exit
                """;

        String menuOptionSelectionByUser = input(displayMainMenu);
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
        String accountNumber = input("Enter you account number: ");
        String pin = input("Enter your pin ");
        String accountBalanceAndDetails = rdBank.checkAndAccountDetails( accountNumber, pin);
        display(accountBalanceAndDetails);
        String checkAccountBalancePrompt = """
                1 ->> Return to main menu
                2 ->> Exit
                """;
        String menuOptionSelectionByUser = input(checkAccountBalancePrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)) {
            case '1' -> mainMenu();
            case '2' -> exitApplication();
        }
    }

    private static void transfer() {
        String senderAccountNumber = input("Enter sender's account number: ");
        String receiverAccountNumber = input("Enter receiver's account number: ");
        String pin = input("Enter your pin ");
        int transferAmount  = Integer.parseInt(input("Enter transfer amount "));
        rdBank.transfer(senderAccountNumber, pin, transferAmount, receiverAccountNumber);

        String transferPrompt = """
                1 ->> Return to main menu
                2 ->> Exit
                """;
        String menuOptionSelectionByUser = input(transferPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)) {
            case '1' -> mainMenu();
            case '2' -> exitApplication();
        }
    }

    private static void withdraw() {
        String accountNumber = input("Enter your account number: ");
        String pin = input("Enter your pin ");
        int withdrawalAmount  = Integer.parseInt(input("Enter withdrawal amount "));
        rdBank.withdraw(accountNumber, pin, withdrawalAmount);
        String withdrawPrompt = """
                1 ->> Return to main menu
                2 ->> Exit
                """;
        String menuOptionSelectionByUser = input(withdrawPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)){
            case '1' -> mainMenu();
            case '2'-> exitApplication();
        }
    }

    private static void deposit() {
        String accountNumber = input("Enter your account number: ");
        int depositAmount = 0;
        try {
            depositAmount  = Integer.parseInt(input("Enter amount to be deposited: "));
        }catch (IllegalArgumentException e){
            display("This is not a valid amount");
        }

        rdBank.deposit(accountNumber, depositAmount);
        String depositPrompt = """
                1 ->> Perform deposit transaction again
                2 ->> Return to main menu
                3 ->> Exit
                """;
        String menuOptionSelectionByUser = input(depositPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)){
            case '1' -> deposit();
            case '2' -> mainMenu();
            case '3'-> exitApplication();
        }

    }

    private static void registerAccount() {
        String firstName = input("Enter your first name: ");
        String secondName = input("Enter your second name: ");
        String pin = input("Enter a secure pin for your account transactions: ");
        int initialDepositAmountIntegerValue = Integer.parseInt(input("Enter an initial deposit amount: "));
        String phoneNumber = input("Enter you phone Number: ");

        rdBank.registerNewCustomer(firstName, secondName, pin, initialDepositAmountIntegerValue, phoneNumber);

        String registeredAccountNumberDisplay = String.format("""
                Registration was successful.
                Here is your account number:
                %s
                Please keep this and your transaction pin safe
                as you will require them for subsequent
                transactions.
                """, rdBank.accountNumberGenerator(phoneNumber));
        display(registeredAccountNumberDisplay);
        String displayPrompt = """
                1 ->> Return to main menu
                2 ->> Exit
                """;
        String menuOptionSelectionByUser = input(displayPrompt);
        switch (menuOptionSelectionByUser.charAt(ZERO)) {
            case '1' -> mainMenu();
            case '2' -> exitApplication();
        }
    }

    private static String input(String prompt) {
        display(prompt);
        return  userInput = input.nextLine();
    }

    private static void display(String message) {
        System.out.println(message);
    }

    private static void exitApplication() {
        String exitMessage = """
                Thank you for banking with us.
                Bye!
                """;
        display(exitMessage);
        System.exit(1);
    }
}
