package bank;

import java.util.Objects;

public class RdAccount {

    private static final int ZERO = 0;
    private String firstName;
    private String lastName;
    private String pin;
    private int accountBalance;
    private String accountNumber;
    private String phoneNumber;

    public RdAccount(String firstName, String lastName, String accountNumber, String pin, int initialDepositAmount, String phoneNumber) {
        initialiseAccountState(firstName, lastName, pin, initialDepositAmount, phoneNumber);
        this.accountNumber = accountNumber;
    }

    private void initialiseAccountState(String firstName, String lastName, String pin, int initialDepositAmount, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        accountBalance = initialDepositAmount;
        this.phoneNumber = phoneNumber;
    }

    public RdAccount(String firstName, String lastName, String pin, int initialDepositAmount, String phoneNumber) {
        initialiseAccountState(firstName, lastName, pin, initialDepositAmount, phoneNumber);
        this.accountNumber = null;
    }

    public void deposit(int depositAmount) {
        validateAmountIsNotNegative(depositAmount);
        accountBalance += depositAmount;
    }

    public void withdraw(int withdrawalAmount, String pin) {
        validatePin(pin);
        validateAmountIsNotNegative(withdrawalAmount);
        validateAmountIsLessThanBalance(withdrawalAmount);
        accountBalance -= withdrawalAmount;
    }

    private void validateAmountIsNotNegative(int amount) throws IllegalArgumentException {
        boolean isAmountLessThanZero = amount < ZERO;
        if (isAmountLessThanZero) throwIllegalArgumentException("\n** Cannot transact negative amount **\n");
    }

    private void validateAmountIsLessThanBalance(int withdrawalAmount) {
        boolean isAmountGreaterThanBalance = withdrawalAmount > accountBalance;
        if(isAmountGreaterThanBalance) throwIllegalArgumentException("\n** Insufficient balance available for withdrawal **\n");
    }

    private void validatePin(String pin) {
        boolean isNotA_ValidPin = !Objects.equals(pin, this.pin);
        if (isNotA_ValidPin) throwIllegalArgumentException("\n** You entered a wrong pin **\n");
    }

    private void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    public String checkAccountNumber() {
        return accountNumber;
    }

    public String checkBalance(String pin) {
        validatePin(pin);
        return String.format("""
                Name: %s %s
                AccountNumber: %s
                AccountBalance: N%d
                """, firstName, lastName, accountNumber, accountBalance);
    }
}
