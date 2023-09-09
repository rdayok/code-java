package play;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArrayElementSwapperTest {
    ArrayElementSwapper arrayElementSwapper = new ArrayElementSwapper();

    @Test
    public void testArrayElementSwapperIsNotNull() {
        assertNotNull(arrayElementSwapper);
    }

    @Test
    public void testElementSwapperReturnsAnArrayWithSwappedElementsAtSpecifiedIndices() {
        int[] inputtedArray = {2, 4, 6, 8, 10};
        int[] expectedArray = {2, 4, 8, 6, 10};
        assertArrayEquals(expectedArray,
                arrayElementSwapper.swapElementsFor(inputtedArray, 2, 3));
    }

    @Test
    public void testWhenIndicesSpecifiedAreSame() {
        int[] inputtedArray = {2, 4, 6, 8, 10};
        int[] expectedArray = {2, 4, 6, 8, 10};
        assertArrayEquals(expectedArray,
                arrayElementSwapper.swapElementsFor(inputtedArray, 2, 2));
    }

    @Test
    public void testWhenIndicesSpecifiedAreOutOfBounds() {
        int[] inputtedArray = {2, 4, 6, 8, 10};
        int[] expectedArray = {2, 4, 6, 8, 10};
        assertArrayEquals(expectedArray,
                arrayElementSwapper.swapElementsFor(inputtedArray, 2, 6));
    }

    @Test
    public void testWhenIndicesSpecifiedAreBelowZero() {
        int[] inputtedArray = {2, 4, 6, 8, 10};
        int[] expectedArray = {2, 4, 6, 8, 10};
        assertArrayEquals(expectedArray,
                arrayElementSwapper.swapElementsFor(inputtedArray, 2, -1));
    }

    @Test
    public void testForElementsThatAreNegative() {
        int[] inputtedArray = {2, 4, -6, 8, 10};
        int[] expectedArray = {2, 4, 8, -6, 10};
        assertArrayEquals(expectedArray,
                arrayElementSwapper.swapElementsFor(inputtedArray, 2, 3));
    }

    @Test
    public void testForElementsThatAreNegativeTwo() {
        int[] inputtedArray = {2, 4, 6, -8, 10};
        int[] expectedArray = {2, 4, -8, 6, 10};
        assertArrayEquals(expectedArray,
                arrayElementSwapper.swapElementsFor(inputtedArray, 2, 3));
    }
}

