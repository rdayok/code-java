package classtacks;

public class MultiplicationWithoutAsterisk {
    private final int ZERO = 0;
    private final int ONE = 0;
    public int product(int firstNumber, int secondNumber) {
        boolean firstOrSecondNumberIsNegative = (firstNumber < ZERO && secondNumber > ZERO) || (firstNumber > ZERO && secondNumber < ZERO);
        boolean firstNumberIsNegative = firstNumber < ZERO;
        boolean secondNumberIsNegative = secondNumber < ZERO;
        if (firstNumberIsNegative) firstNumber = makeNumberPositive(firstNumber);
        if (secondNumberIsNegative) secondNumber = makeNumberPositive(secondNumber);
        int product = ZERO;
        for (int counter = ONE; counter < secondNumber; counter++){
            product += firstNumber;
        }
        if (firstOrSecondNumberIsNegative) product = makeNumberNegative(product);
        return product;
    }

    private int makeNumberNegative(int product) {
        int negativeValueOfInput = ZERO;
        while(product > 0){
            product--;
            negativeValueOfInput--;
        }
        return negativeValueOfInput;
    }

    private int makeNumberPositive(int negativeNumberInput) {
        int positiveValueOfInput = ZERO;
        while (negativeNumberInput < ZERO ){
            negativeNumberInput++;
            positiveValueOfInput++;
        }
        return positiveValueOfInput;
    }
}
