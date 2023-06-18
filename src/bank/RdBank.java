package bank;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RdBank {
    private List<RdAccount> rdBankListOfAccounts;
    private List<String> listOfPhoneNumbers;
    private final int ZERO = 0;

    public RdBank() {
        rdBankListOfAccounts = new ArrayList<>();
        listOfPhoneNumbers = new ArrayList<>();
    }

    public void registerNewCustomer(String firstName, String lastName, String pin, int initialDepositAmount, String phoneNumber) {
        validateInputAllUserInput(firstName, lastName, pin, phoneNumber);
        RdAccount rdAccount = new RdAccount(firstName, lastName, accountNumberGenerator(phoneNumber), pin, initialDepositAmount, phoneNumber);
        rdBankListOfAccounts.add(rdAccount);
        listOfPhoneNumbers.add(phoneNumber);
    }

    private void validateInputAllUserInput(String firstName, String lastName, String pin, String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        validatePin(pin);
        ValidateName(firstName);
        ValidateName(lastName);
    }

    private void ValidateName(String inputtedName) {
        validateLengthOfName(inputtedName);
        validateNameContainsOnlyCharacter(inputtedName);
    }

    private void validateNameContainsOnlyCharacter(String inputtedName) {
        String errorMessageForNameThanContainsNumbers = "\n** Please Names should contain only alphabets **\n";
        boolean isNotCharacter;
        for ( int index = ZERO; index < inputtedName.length(); index++) {
            isNotCharacter = !(Character.isLetter(inputtedName.charAt(index)));
            if (isNotCharacter) throwIllegalArgumentException(errorMessageForNameThanContainsNumbers);
        }
    }

    private void validateLengthOfName(String inputtedName) {
        String errorMessageForWrongLengthOfName = "\n** Please you can not enter a single letter as name **\n";
        final int TWO = 2;
        boolean isNotA_validNameLength = inputtedName.length() < TWO;
        if (isNotA_validNameLength) throwIllegalArgumentException(errorMessageForWrongLengthOfName);
    }

    private void validatePin(String pin) {
        String errorMessageForPinLength = "\n** Please enter a four digit pin **\n";
        final int FOUR = 4;
        validateInputCharacterLength(pin, FOUR, errorMessageForPinLength);
        String errorMessageForPinWithCharacter = "\n** Please enter four digits with no alphabet **\n";
        validateInputContainsDigitsOnly(pin, errorMessageForPinWithCharacter);
    }

    private void validatePhoneNumber(String phoneNumber) {
        final int ELEVEN = 11;
        String errorMessageForPhoneNumberLength = ("\n** Please enter an 11 digit phone number **\n");
        String errorMessageForNumberAlreadyRegistered = "\n** This phone number is registered. Please provide another so we can serve you better **\n";
        String errorMessageForPhoneNumberWithCharacter = "\n** This phone number contains alphabet. please Enter a valid phone Number **\n";
        validateInputCharacterLength(phoneNumber, ELEVEN, errorMessageForPhoneNumberLength);
        validateInputContainsDigitsOnly(phoneNumber, errorMessageForPhoneNumberWithCharacter);
        validateIfPhoneNumberExistInOurListOfRegisteredNumbers(phoneNumber, errorMessageForNumberAlreadyRegistered);
    }

    private void validateIfPhoneNumberExistInOurListOfRegisteredNumbers(String phoneNumber, String errorMessageForNumberAlreadyRegistered) {
        for (String savedPhoneNumber : listOfPhoneNumbers){
            boolean isA_registeredPhoneNumber = Objects.equals(savedPhoneNumber, phoneNumber);
            if (isA_registeredPhoneNumber) throwIllegalArgumentException(errorMessageForNumberAlreadyRegistered);
        }
    }

    private void validateInputContainsDigitsOnly(String userInput, String errorMessage) {
        boolean isNotA_number;
        for ( int index = ZERO; index < userInput.length(); index++) {
            isNotA_number = !(Character.isDigit(userInput.charAt(index)));
            if (isNotA_number) throwIllegalArgumentException(errorMessage);
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
        accountDetails = foundAccount.checkBalance(pin);
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

    private RdAccount findAccountByAccountNumber(String accountNumber) throws IllegalArgumentException {
        for (RdAccount rdAccount : rdBankListOfAccounts) {
            boolean givenAccountNumberIsSameWithTheObjects = Objects.equals(accountNumber, rdAccount.checkAccountNumber());
            if(givenAccountNumberIsSameWithTheObjects) return rdAccount;
        }
        throw new  IllegalArgumentException("\n** This given account number is not found in our list of accounts **\n");
    }

    public void transfer(String senderAccount, String pin, int transferAmount, String receiverAccount) {
        RdAccount foundSendersAccount = findAccountByAccountNumber(senderAccount);
        RdAccount foundReceiversAccount = findAccountByAccountNumber(receiverAccount);
        foundSendersAccount.withdraw(transferAmount, pin);
        foundReceiversAccount.deposit(transferAmount);
    }


    private void throwIllegalArgumentException(String message) throws IllegalArgumentException {
        throw new  IllegalArgumentException(message);
    }

}

