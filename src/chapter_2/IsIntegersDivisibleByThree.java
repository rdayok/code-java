package chapter_2;

public class IsIntegersDivisibleByThree {
    private boolean isDivisibleByThree;
    public void isDivisibleByThree(int integer) {
        int integerThree = 3, integerZero = 0;
        if (integer % integerThree == integerZero) isDivisibleByThree = true;
    }

    public boolean isDivisibleByThree() {
        return isDivisibleByThree;
    }
}
