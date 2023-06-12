package bank;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

public class RdBank {
    private List<RdAccount> rdBankListOfAccounts = new ArrayList<>();
    private final int ZERO = 0;

    public void registerNewCustomer(String firstName, String lastName, String pin, int initialDepositAmount, String phoneNumber) {
        validateInputAllUserInput(firstName, lastName, pin, phoneNumber);
        RdAccount rdAccount = new RdAccount(firstName, lastName, accountNumberGenerator(phoneNumber), pin, initialDepositAmount, phoneNumber);
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
        for ( int index = ZERO; index < inputtedName.length(); index++) {
            isA_digit = Character.isDigit(inputtedName.charAt(index));
            if (isA_digit) throwIllegalArgumentException(errorMessageForNameThanContainsNumbers);
        }
    }

    private void validateLengthOfName(String inputtedName) {
        String errorMessageForWrongLengthOfName = "Please you can not enter a single letter as name";
        final int TWO = 2;
        boolean isNotA_validNameLength = inputtedName.length() < TWO;
        if (isNotA_validNameLength) throwIllegalArgumentException(errorMessageForWrongLengthOfName);
    }

    private void validatePin(String pin) {
        String errorMessageForPinLength = "Please enter a four digit pin";
        final int FOUR = 4;
        validateInputCharacterLength(pin, FOUR, errorMessageForPinLength);
        String errorMessageForPinWithCharacter = "Please enter four digits with no alphabet. ";
        validateNoAlphabetInInput(pin, errorMessageForPinWithCharacter);
    }

    private void validatePhoneNumber(String phoneNumber) {
        String errorMessageForPhoneNumberLength = ("Please enter an 11 digit phone number please. ");
        final int ELEVEN = 11;
        validateInputCharacterLength(phoneNumber, ELEVEN, errorMessageForPhoneNumberLength);
        String errorMessageForPhoneNumberWithCharacter = "This phone number contains alphabet. please Enter a valid phone Number";
        validateNoAlphabetInInput(phoneNumber, errorMessageForPhoneNumberWithCharacter);
    }

    private void validateNoAlphabetInInput(String userInput, String errorMessage) {
        boolean isAnAlphabet;
        for ( int index = ZERO; index < userInput.length(); index++) {
            isAnAlphabet = !(Character.isDigit(userInput.charAt(index)));
            if (isAnAlphabet) throwIllegalArgumentException(errorMessage);
        }
    }

    private void validateInputCharacterLength(String userInput, int expectedLengthOfUserInput,  String errorMessage) {
        boolean isNotA_validLengthOfUserInput = userInput.length() != expectedLengthOfUserInput;
        if (isNotA_validLengthOfUserInput) throwIllegalArgumentException(errorMessage);
    }

    public @NotNull String accountNumberGenerator(String phoneNumber) {
        StringBuilder generatedAccountNumber = new StringBuilder();
        int ONE = 1;
        for (int index = ONE; index < phoneNumber.length(); index++) generatedAccountNumber.append(phoneNumber.charAt(index));
        return String.valueOf(generatedAccountNumber);
    }

    public String checkAndAccountDetails(String accountNumber, String pin) {
        String accountDetails = "";
        RdAccount foundAccount = findAccountByAccountNumber(accountNumber);
        accountDetails = foundAccount.checkAccountDetails(pin);
        return accountDetails;
    }

    public void deposit(String accountNumber, int depositAmount) {
        RdAccount foundAccount = findAccountByAccountNumber(accountNumber);
        foundAccount.deposit(depositAmount);
    }

    public void withdraw(String accountNumber, String pin, int withdrawalAmount) {
        RdAccount foundAccount = findAccountByAccountNumber(accountNumber);
        foundAccount.withdraw(withdrawalAmount, pin);
    }

    private RdAccount findAccountByAccountNumber(String accountNumber) throws InputMismatchException {
        for (RdAccount rdAccount : rdBankListOfAccounts) {
            boolean givenAccountNumberIsSameWithTheObjects = Objects.equals(accountNumber, rdAccount.checkAccountNumber());
            if(givenAccountNumberIsSameWithTheObjects) return rdAccount;
        }
        throw new NullPointerException("This given account number is not found in our list of accounts");
    }

    public void transfer(String senderAccount, String receiverAccount, int transferAmount, String pin) {
        RdAccount foundSendersAccount = findAccountByAccountNumber(senderAccount);
        RdAccount foundReceiversAccount = findAccountByAccountNumber(receiverAccount);
        boolean senderHasBeenDebited = isSenderDebited(foundSendersAccount, transferAmount, pin);
        if (senderHasBeenDebited){
            foundReceiversAccount.deposit(transferAmount);
        }
    }

    private boolean isSenderDebited(RdAccount foundSenderAccount, int transferAmount, String pin) {
        foundSenderAccount.withdraw(transferAmount, pin);
        return true;
    }

    private void throwIllegalArgumentException(String message) throws InputMismatchException {
        throw new  IllegalArgumentException(message);
    }

}

