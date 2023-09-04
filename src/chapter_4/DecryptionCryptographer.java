package chapter_4;

public class DecryptionCryptographer {

    private String userInputtedNumber;


    public void readUserInputOf(String userInputtedFourDigitsNumber) {
        validate(userInputtedFourDigitsNumber);
        userInputtedNumber = userInputtedFourDigitsNumber;
    }

    public String getDecryptedInput() {
        return userInputtedNumber;
    }

    public void swapDigitsOfEncryptedNumber() {
        userInputtedNumber = String.valueOf(userInputtedNumber.charAt(2)) +
                userInputtedNumber.charAt(3) +
                userInputtedNumber.charAt(0) +
                userInputtedNumber.charAt(1);
    }

    public void decryptUserInput() {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < userInputtedNumber.length(); index++) {
            int digit = Character.getNumericValue(userInputtedNumber.charAt(index));
            int number = (digit + 10 - 7) % 10;
            builder.append(number);
        }
        userInputtedNumber = builder.toString();
    }

    private void validate(String userInputtedFourDigitsNumber) {
        validateLengthOf(userInputtedFourDigitsNumber);
        validateOnlyNumbersAreFoundIn(userInputtedFourDigitsNumber);
    }

    private void validateOnlyNumbersAreFoundIn(String userInputtedFourDigitsNumber) {
        for (int index = 0; index < userInputtedFourDigitsNumber.length(); index++) {
            if(!Character.isDigit(userInputtedFourDigitsNumber.charAt(index))) throwIllegalArgumentException();
        }
    }

    private void validateLengthOf(String userInputtedFourDigitsNumber) {
        if(userInputtedFourDigitsNumber.length() != 4) throwIllegalArgumentException();
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException("Please enter a four digit number");
    }
}
