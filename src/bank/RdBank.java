package bank;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

public class RdBank {
    private List<RdAccount> rdBankListOfAccounts = new ArrayList<>();
    private final int ONE = 1;

    public void registerNewCustomer(String firstName, String lastName, String pin, int initialDepositAmount, String phoneNumber) {
        validateInputAllUserInput(firstName, lastName, pin, phoneNumber);

        RdAccount rdAccount = new RdAccount(firstName, lastName, pin, initialDepositAmount,phoneNumber, accountNumberGenerator(phoneNumber));
        rdBankListOfAccounts.add(rdAccount);
    }

    private void validateInputAllUserInput(String firstName, String lastName, String pin, String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        validatePin(pin);
        ValidateName(firstName);
        ValidateName(lastName);
    }

    private void ValidateName(String inputtedName) {
        validateLengthOfName(inputtedName);
        validateNameDoesNotContainNumbers(inputtedName);
    }

    private void validateNameDoesNotContainNumbers(String inputtedName) {
        String errorMessageForNameThanContainsNumbers = "Please Names should not contain numbers";
        boolean isA_digit;
        for ( int index = 0; index < inputtedName.length(); index++) {
            isA_digit = Character.isDigit(inputtedName.charAt(index));
            if (isA_digit) throwIllegalArgumentException(errorMessageForNameThanContainsNumbers);
        }
    }

    private void validateLengthOfName(String inputtedName) {
        String errorMessageForWrongLengthOfName = "Please you can not enter a single letter as name";
        if (inputtedName.length() < 2) throwIllegalArgumentException(errorMessageForWrongLengthOfName);
    }

    private void validatePin(String pin) {
        String errorMessageForPinLength = "Please enter a four digit pin";
        validateInputCharacterLength(pin, 4, errorMessageForPinLength);
        String errorMessageForPinWithCharacter = "Please enter four digits with no alphabet. ";
        validateNoAlphabetInInput(pin, errorMessageForPinWithCharacter);
    }

    private void validatePhoneNumber(String phoneNumber) {
        String errorMessageForPhoneNumberLength = ("Please enter an 11 digit phone number please. ");
        validateInputCharacterLength(phoneNumber, 11, errorMessageForPhoneNumberLength);
        String errorMessageForPhoneNumberWithCharacter = "This phone number contains alphabet. please Enter a valid phone Number";
        validateNoAlphabetInInput(phoneNumber, errorMessageForPhoneNumberWithCharacter);
    }

    private void validateNoAlphabetInInput(String userInput, String errorMessage) {
        boolean isAnAlphabet;
        for ( int index = 0; index < userInput.length(); index++) {
            isAnAlphabet = !(Character.isDigit(userInput.charAt(index)));
            if (isAnAlphabet) throwIllegalArgumentException(errorMessage);
        }
    }

    private void validateInputCharacterLength(String userInput, int lengthOfInput,  String errorMessage) {
        if (userInput.length() != lengthOfInput) throwIllegalArgumentException(errorMessage);
    }

    public @NotNull String accountNumberGenerator(String phoneNumber) {
        StringBuilder generatedAccountNumber = new StringBuilder();
        for ( int index = ONE; index < phoneNumber.length(); index++) generatedAccountNumber.append(phoneNumber.charAt(index));
        return String.valueOf(generatedAccountNumber);
    }

    public String checkAndAccountDetails(String accountNumber, String pin) {
        String accountDetails = "";
        RdAccount accountObjectWithTheGivenAccountNumber = findAccountByAccountNumber(accountNumber);
        accountDetails = accountObjectWithTheGivenAccountNumber.checkAccountDetails(pin);
        return accountDetails;
    }

    public void deposit(String accountNumber, int depositAmount) {
        RdAccount accountObjectWithTheGivenAccountNumber = findAccountByAccountNumber(accountNumber);

        accountObjectWithTheGivenAccountNumber.deposit(depositAmount);
    }

    public void withdraw(String accountNumber, String pin, int withdrawalAmount) {
        RdAccount foundAccount = findAccountByAccountNumber(accountNumber);
        foundAccount.withdraw(pin, withdrawalAmount);
    }

    private RdAccount findAccountByAccountNumber(String accountNumber) throws InputMismatchException {
        for (RdAccount rdAccount : rdBankListOfAccounts) {
            if(Objects.equals(accountNumber, rdAccount.checkAccountNumber())){
                return rdAccount;
            }
        }
        throw new NullPointerException("This given account number is not found our list of accounts");
    }

    public void transfer(String senderAccount, String pin, int transferAmount, String receiverAccount) {
        RdAccount accountObjectWithTheSenderAccountNumber = findAccountByAccountNumber(senderAccount);
        RdAccount accountObjectWithTheReceiverAccountNumber = findAccountByAccountNumber(receiverAccount);

        boolean senderCanTransfer = canSenderTransfer(accountObjectWithTheSenderAccountNumber, pin);
        if (senderCanTransfer){
            accountObjectWithTheSenderAccountNumber.withdraw(pin, transferAmount);
            accountObjectWithTheReceiverAccountNumber.deposit(transferAmount);
        }
    }

    private boolean canSenderTransfer(RdAccount accountObjectWithTheSenderAccountNumber, String pin) {
        return accountObjectWithTheSenderAccountNumber.canSenderSendMoney(pin);
    }

    private void throwIllegalArgumentException(String message) throws InputMismatchException {
        throw new  IllegalArgumentException(message);
    }

}

