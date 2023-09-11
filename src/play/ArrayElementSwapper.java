package play;

public class ArrayElementSwapper {


    public int[] swapElementsFor(int[] inputtedArray, int indexA, int indexB) {
        final int ARRAY_LAST_INDEX = inputtedArray.length;
        int ZERO = 0;
        boolean isInvalidIndexForGivenArray = indexA == indexB || indexA >= ARRAY_LAST_INDEX || indexB >= ARRAY_LAST_INDEX || indexA < ZERO || indexB < ZERO;
        if (isInvalidIndexForGivenArray) return inputtedArray;
        performSwappingLogic(inputtedArray, indexA, indexB);
        return inputtedArray;
    }

    private void performSwappingLogic(int[] inputtedArray, int indexA, int indexB) {
        inputtedArray[indexA] += inputtedArray[indexB];
        inputtedArray[indexB] = inputtedArray[indexA] - inputtedArray[indexB];
        inputtedArray[indexA] -= inputtedArray[indexB];
    }

}
