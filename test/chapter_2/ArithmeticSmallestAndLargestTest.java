package chapter_2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticSmallestAndLargestTest {
    ArithmeticSmallestAndLargest calculateAndCompare = new ArithmeticSmallestAndLargest();
    @Test public void sumOfThreeIntegersTest(){
        calculateAndCompare.sumOfThreeIntegers(43,5,66);
        assertEquals(114, calculateAndCompare.getSumOfThreeIntegers());
    }
    @Test public void averageOfThreeIntegersAsInt(){
        calculateAndCompare.averageOfThreeIntegersAsInt(43,6,66);
        assertEquals(38, calculateAndCompare.getAverageOfThreeIntegersAsInt());
    }
    @Test public void productOfThreeIntegers(){
        calculateAndCompare.productOfThreeIntegers(4,5,43);
        assertEquals(860, calculateAndCompare.getProductOfThreeIntegers());
    }
    @Test public void smallestAndLargestAndSmallestIntegerTest(){
        calculateAndCompare.setSmallestAndLargestInteger(4, 9, 23);
        assertEquals("The smallest integer is 4 and the largest integer is 23",
                calculateAndCompare.getSmallestAndLargestInteger());
    }
}
