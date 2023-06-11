package array_exercise;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class SplitDigitsOfNumberOrArrayNumberElementTest {

    SplitDigitsOfNumberOrArrayNumberElement splitDigitsOfNumber = new SplitDigitsOfNumberOrArrayNumberElement();

    @Test public void testObjectExist(){
        assertNotNull(splitDigitsOfNumber);
    }

    @Test public void testSplittingDigits(){
        splitDigitsOfNumber.splitDigitsOfNumber(2342);

        Object[] expectedArray = {2, 3, 4, 2};
        assertArrayEquals(expectedArray, splitDigitsOfNumber.getExpectedArray());
    }

    @Test public void testSplittingDigits2(){
        splitDigitsOfNumber.splitDigitsOfNumber(5432);

        Object[] expectedArray = {5, 4, 3, 2};
        assertArrayEquals(expectedArray, splitDigitsOfNumber.getExpectedArray());
    }

    @Test public void testPassingAnArrayToSplitDigits(){
        int[] passedArray = {5, 44, 34, 2};
        Object[] expectedArray = {5, 4, 4, 3, 4, 2};
        splitDigitsOfNumber.splitDigitsOfNumber(passedArray);

        assertArrayEquals(expectedArray, splitDigitsOfNumber.getExpectedArray());
    }

}
