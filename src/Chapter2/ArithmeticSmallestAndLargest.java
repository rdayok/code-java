package Chapter2;

public class ArithmeticSmallestAndLargest {
    private int sumOfThreeIntegers;
    private int averageOfThreeIntegers;
    private int productOfThreeIntegers;
    private int smallestInteger;
    private int largestInteger;

    public void sumOfThreeIntegers(int integerOne, int integerTwo, int integerThree) {
        sumOfThreeIntegers = integerOne + integerTwo + integerThree;
    }

    public int getSumOfThreeIntegers() {
        return sumOfThreeIntegers;
    }

    public void averageOfThreeIntegersAsInt(int integerOne, int integerTwo, int integerThree) {
        int numberOfIntegers = 3;
        averageOfThreeIntegers = (integerOne + integerTwo + integerThree) / numberOfIntegers;
    }

    public int getAverageOfThreeIntegersAsInt() {
        return averageOfThreeIntegers;
    }

    public void productOfThreeIntegers(int integerOne, int integerTwo, int integerThree) {
        productOfThreeIntegers = integerOne * integerTwo * integerThree;
    }

    public int getProductOfThreeIntegers() {
        return productOfThreeIntegers;
    }

    public void setSmallestAndLargestInteger(int integerOne, int integerTwo, int integerThree) {
        smallestInteger = setSmallestInteger(integerOne, integerTwo, integerThree);
        largestInteger = checkLargestInteger(integerOne, integerTwo, integerThree);
    }

    private int checkLargestInteger(int integerOne, int integerTwo, int integerThree) {
        int largestInteger = 0;
        if (integerOne > integerTwo && integerOne > integerThree) largestInteger = integerOne;
        if (integerTwo > integerOne && integerTwo > integerThree) largestInteger = integerTwo;
        if (integerThree > integerOne && integerThree > integerTwo) largestInteger = integerThree;
        return largestInteger;
    }

    private int setSmallestInteger(int integerOne, int integerTwo, int integerThree) {
        int smallestInteger = 0;
        if (integerOne < integerTwo && integerOne < integerThree) smallestInteger = integerOne;
        if (integerTwo < integerOne && integerTwo < integerThree) smallestInteger = integerTwo;
        if (integerThree < integerOne && integerThree < integerTwo) smallestInteger = integerThree;
        return smallestInteger;
    }

    public String getSmallestAndLargestInteger() {
        return "The smallest integer is "+ smallestInteger +" and the largest integer is "+ largestInteger;
    }
}
