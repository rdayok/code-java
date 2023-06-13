package array_exercise;

public class DoubleArraySize {

    public int[] doubleArraySize(int[] givenArray) {
        int TWO = 2;
        int doubledArrayLength = givenArray.length * TWO;
        int[] newArray = new int[doubledArrayLength];
        int ZERO = 0;
        for (int index = ZERO; index < doubledArrayLength; index++){
            if (index < givenArray.length) newArray[index] = givenArray[index];
        }
        return newArray;
    }
}
