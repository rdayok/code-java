package play;

import java.util.Objects;

public class CallPoints {
    public static void main(String[] args) {
        String[] inputtedArray = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int result = callPoints(inputtedArray);
        System.out.println(result);
    }

    private static int callPoints(String[] inputtedArray) {
        int[] newCollection = new int[inputtedArray.length];
        int newCollectionIndex = 0;
        for (String elementOfInputtedArray : inputtedArray) {
            if (isNumeric(elementOfInputtedArray)) {
                newCollection[newCollectionIndex] = Integer.parseInt(elementOfInputtedArray);
                newCollectionIndex++;
            } else if (Objects.equals(elementOfInputtedArray, "C")) {
                newCollection[--newCollectionIndex] = 0;
            } else if (Objects.equals(elementOfInputtedArray, "D")) {
                newCollection[newCollectionIndex] = newCollection[newCollectionIndex - 1] * 2;
                newCollectionIndex++;
            } else if (Objects.equals(elementOfInputtedArray, "+")) {
                newCollection[newCollectionIndex] = newCollection[newCollectionIndex - 1] + newCollection[newCollectionIndex - 2];
                newCollectionIndex++;
            }
        }
        return sumNewCollection(newCollection);
    }

    private static int sumNewCollection(int[] integers) {
        int total = 0;
        for(int integer : integers){
            total += integer;
        }
        return total;
    }

    private static boolean isNumeric(String element) {
        try{
            int number = Integer.parseInt(element);
            return true;
        }catch (NumberFormatException exception){
            return false;
        }
    }


}
