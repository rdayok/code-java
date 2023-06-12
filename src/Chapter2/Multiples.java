package Chapter2;

public class Multiples {
    private boolean isTripledFirstIntegerMultipleOfDoubledSecondInteger;
    public final int ZERO = 0;
    public final int TWO = 2;
    public final int THREE = 3;
    public void multiplesChecker(int firstInteger, int secondInteger) {
        firstInteger = integerTripled(firstInteger);
        secondInteger = integerDoubled(secondInteger);
        if (secondInteger % firstInteger == ZERO) isTripledFirstIntegerMultipleOfDoubledSecondInteger = true;
    }

    private int integerDoubled(int secondInteger) {
        return secondInteger *= TWO;
    }


    private int integerTripled(int firstInteger) {
        return  firstInteger *= THREE;
    }

    public boolean isTripledFirstIntegerMultipleOfDoubledSecondInteger() {
        return isTripledFirstIntegerMultipleOfDoubledSecondInteger;
    }
}
