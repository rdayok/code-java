package play;

public class ArrayElementSwapper {

    private int[] inputtedArray;
    private boolean elementAtIndexA_isNegative;
    private boolean elementAtIndexB_isNegative;
    private final int ZERO = 0;
    private final int ONE = 1;



    public int[] swapElementsFor(int[] inputtedArray, int indexA, int indexB) {
        final int ARRAY_LAST_INDEX = inputtedArray.length;
        this.inputtedArray = inputtedArray;
        boolean isInvalidIndexForGivenArray = indexA == indexB || indexA >= ARRAY_LAST_INDEX || indexB >= ARRAY_LAST_INDEX || indexA < ZERO || indexB < ZERO;
        if (isInvalidIndexForGivenArray) return inputtedArray;
        performSwappingLogic(inputtedArray, indexA, indexB);
        return inputtedArray;
    }

    private void performSwappingLogic(int[] inputtedArray, int indexA, int indexB) {
        isNegativeElementAt(indexA, "indexA");
        isNegativeElementAt(indexB, "indexB");
        inputtedArray[indexA] += inputtedArray[indexB];
        inputtedArray[indexB] = inputtedArray[indexA] - inputtedArray[indexB];
        inputtedArray[indexA] -= inputtedArray[indexB];
        changeSymbolForElementsAt(indexA, indexB);
    }

    private void changeSymbolForElementsAt(int indexA, int indexB) {
        if(elementAtIndexA_isNegative)  inputtedArray[indexB] *= -ONE;
        if(elementAtIndexB_isNegative) inputtedArray[indexA] *= -ONE;
    }

    private void isNegativeElementAt(int givenIndex, String index) {
        if(inputtedArray[givenIndex] < ZERO){
            if(index.equals("indexA")) elementAtIndexA_isNegative = true;
            if(index.equals("indexB")) elementAtIndexB_isNegative = true;
            inputtedArray[givenIndex] *= -ONE;
        }
    }
}
