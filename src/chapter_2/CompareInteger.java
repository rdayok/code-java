package chapter_2;

public class CompareInteger {
    private String integerCharacteristics;
    public final int ONE_HUNDRED = 0;

    public void compareIntegerToHundred(int integerInput) {
        if (integerInput < ONE_HUNDRED) integerCharacteristics = "Integer "+
                integerInput + " is less than 100";
        if (integerInput > ONE_HUNDRED) integerCharacteristics = "Integer "+
                integerInput +" is greater than 100";
        if (integerInput == ONE_HUNDRED) integerCharacteristics = "Integer "+
                integerInput +" is equal to 100";
    }

    public String getIntegerCharacteristics() {
        return integerCharacteristics;
    }

    public void compareSquaredIntegerToHundred(int integerInput) {
        int integerSquare = integerInput * integerInput;
        if (integerSquare < ONE_HUNDRED) integerCharacteristics = "Integer "+
                integerInput + " square is less than 100";
        if (integerSquare > ONE_HUNDRED) integerCharacteristics = "Integer "+
                integerInput + " square is greater than 100";
        if (integerSquare == ONE_HUNDRED) integerCharacteristics = "Integer "+
                integerInput + " square is equal to 100";
    }
}
