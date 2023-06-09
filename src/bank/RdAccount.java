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

    public RdAccount(String firstName, String lastName, String pin, int initialDepositAmount, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        accountBalance = initialDepositAmount;
        this.accountNumber = phoneNumber;
    }
    public RdAccount(String firstName, String lastName, String pin, int initialDepositAmount, String phoneNumber, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        accountBalance = initialDepositAmount;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
    }

    public void deposit(int depositAmount) {
        validateAmountIsNotNegative(depositAmount);
        accountBalance += depositAmount;

    }

    public void withdraw(String pin, int withdrawalAmount) {
        validatePin(pin);
        validateAmountIsNotNegative(withdrawalAmount);
        validateAmountCanBeWithdrawn(withdrawalAmount);
        accountBalance -= withdrawalAmount;
    }

    public int checkBalance(String pin)  {
        validatePin(pin);
        return accountBalance;
    }

    private void validateAmountIsNotNegative(int amount) throws IllegalArgumentException {
        boolean depositAmountLessThanZero = amount < ZERO;
        if (depositAmountLessThanZero) throwIllegalArgumentException("Cannot transact negative amount. ");
    }

    private void validateAmountCanBeWithdrawn(int withdrawalAmount) {
        boolean amountIsGreaterThanBalance = withdrawalAmount > accountBalance;
        if(amountIsGreaterThanBalance) throwIllegalArgumentException("Insufficient balance available for withdrawal");
    }

    private void validatePin(String pin) {
        boolean isNotA_ValidPin = !Objects.equals(pin, this.pin);
        if (isNotA_ValidPin) {
            throwIllegalArgumentException("You entered a wrong pin");
        }
    }

    private void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    public String checkAccountNumber() {
        return accountNumber;
    }

    public String checkAccountDetails(String pin) {
        validatePin(pin);
        return String.format("""
                Name: %s %s
                AccountNumber: %s
                AccountBalance: N%d
                """, firstName, lastName, accountNumber, accountBalance);
    }

    public boolean canSenderSendMoney(String pin) {
        return Objects.equals(pin, this.pin);
    }
}
