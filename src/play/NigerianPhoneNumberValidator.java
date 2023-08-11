package play;

public class NigerianPhoneNumberValidator {
    public boolean isValidNigerianPhoneNumber(String number) {
        boolean isA_validNumber = ( number.startsWith("080") && number.charAt(3) != '0' && number.length() == 11 && isWithoutAlphabetOrSymbol(number, 3)) ||
                (number.startsWith("234-80") && number.charAt(6) != '0' && number.length() == 14 && isWithoutAlphabetOrSymbol(number, 6)) ||
                (number.startsWith("+234-80") && number.charAt(7) != '0' && number.length() == 15 && isWithoutAlphabetOrSymbol(number, 7)) ||
                (number.startsWith("(+234)-80") && number.charAt(9) != '0' && number.length() == 17 && isWithoutAlphabetOrSymbol(number, 9));
        if(isA_validNumber) return true;
        return false;
    }

    private boolean isWithoutAlphabetOrSymbol(String number, int startIndex) {
        for(int index = startIndex; index < number.length(); index++){
            boolean isNotA_number = !Character.isDigit(number.charAt(index));
            if(isNotA_number) return false;
        }
        return true;
    }
}
