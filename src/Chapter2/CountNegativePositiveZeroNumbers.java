package Chapter2;

public class CountNegativePositiveZeroNumbers {
    private int positive;
    private int negative;
    private int zero;
    public final int ZERO = 0;
    public final int ONE = 1;
    public void countPositiveNegativeZeroNumbers(float inputtedNumber) {
        int numberZero = ZERO;
        if (inputtedNumber > numberZero) positive += ONE;
        else if (inputtedNumber < numberZero) negative += ONE;
        else zero += ONE;
    }

    public String getCountOfPositiveNegativeZeroNumber() {
        return zero +" zero, "+ negative +" negative and "+ positive +" positive numbers";
    }
}
