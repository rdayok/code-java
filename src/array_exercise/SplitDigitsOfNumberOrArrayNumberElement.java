package array_exercise;

import java.util.ArrayList;
import java.util.List;


public class SplitDigitsOfNumberOrArrayNumberElement {
    private List<Integer> listOfSplittedDigits = new ArrayList<>();
    public void splitDigitsOfNumber(int number) {
        int digit;
        String numberAsString = String.valueOf(number);
        for (int index = 0; index < numberAsString.length(); index++){
            digit = Integer.parseInt(String.valueOf(numberAsString.charAt(index)));
            listOfSplittedDigits.add(digit);
        }
    }

    public void splitDigitsOfNumber(int[] passedArray) {
        for (int element : passedArray) splitDigitsOfNumber(element);
    }

    public Object[] getExpectedArray() {
        return listOfSplittedDigits.toArray();
    }

}
