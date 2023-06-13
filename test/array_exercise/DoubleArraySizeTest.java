package array_exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DoubleArraySizeTest {
    DoubleArraySize doubleArraySize = new DoubleArraySize();
    @Test public void doubleArraySizeTest(){
        int[] givenArray = {3, 4, 5, 6, 5, 9};
        int[] expectedDoubledArray = {3, 4, 5, 6, 5,9, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expectedDoubledArray,doubleArraySize.doubleArraySize(givenArray));
    }
}
