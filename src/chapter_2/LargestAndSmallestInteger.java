package chapter_2;

public class LargestAndSmallestInteger {
    private int largestInteger;
    private int smallestInteger;

    public void largestAndSmallestIntegerChecker(int firstInteger, int secondInteger, int thirdInteger, int fourthInteger, int fifthInteger) {

        checkLargestInteger(firstInteger, secondInteger, thirdInteger, fourthInteger, fifthInteger);
        checkSmallestInteger(firstInteger, secondInteger, thirdInteger, fourthInteger, fifthInteger);
    }

    private void checkSmallestInteger(int firstInteger, int secondInteger, int thirdInteger, int fourthInteger, int fifthInteger) {
        if(firstInteger < secondInteger && firstInteger < thirdInteger &&
                firstInteger < fourthInteger && firstInteger < fifthInteger){
            smallestInteger = firstInteger;
        } else if (secondInteger < firstInteger && secondInteger < thirdInteger &&
                secondInteger < fourthInteger && secondInteger < fifthInteger) {
            smallestInteger = secondInteger;
        } else if (thirdInteger < firstInteger && thirdInteger < secondInteger &&
                thirdInteger < fourthInteger && thirdInteger < fifthInteger){
            smallestInteger = thirdInteger;
        } else if (fourthInteger < firstInteger && fourthInteger < secondInteger &&
                fourthInteger < thirdInteger && fourthInteger < fifthInteger){
            smallestInteger = fourthInteger;
        } else smallestInteger = fifthInteger;
    }

    private void checkLargestInteger(int firstInteger, int secondInteger, int thirdInteger, int fourthInteger, int fifthInteger) {
        if(firstInteger > secondInteger && firstInteger > thirdInteger &&
                firstInteger > fourthInteger && firstInteger > fifthInteger){
            largestInteger = firstInteger;
        } else if (secondInteger > firstInteger && secondInteger > thirdInteger &&
                secondInteger > fourthInteger && secondInteger > fifthInteger) {
            largestInteger = secondInteger;
        } else if (thirdInteger > firstInteger && thirdInteger > secondInteger &&
                thirdInteger > fourthInteger && thirdInteger > fifthInteger){
            largestInteger = thirdInteger;
        } else if (fourthInteger > firstInteger && fourthInteger > secondInteger &&
                fourthInteger > thirdInteger && fourthInteger > fifthInteger){
            largestInteger = fourthInteger;
        } else largestInteger = fifthInteger;
    }

    public String displayLargestAndSmallestInteger() {
        return "Largest integer is "+ largestInteger +" and smallest integer is "+ smallestInteger;
    }
}
