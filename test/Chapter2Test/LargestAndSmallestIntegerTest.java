package Chapter2Test;

import Chapter2.LargestAndSmallestInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestAndSmallestIntegerTest {
    LargestAndSmallestInteger rdChecker = new LargestAndSmallestInteger();
    @Test public void largestAndSmallestTest1(){
        rdChecker.largestAndSmallestIntegerChecker(45, 3,
                677, 5332, 6);
        assertEquals("Largest integer is 5332 and smallest integer is 3",
                rdChecker.displayLargestAndSmallestInteger());
    }
    @Test public void largestAndSmallestTest2(){
        rdChecker.largestAndSmallestIntegerChecker(90, 353,
                677, 32, 6);
        assertEquals("Largest integer is 677 and smallest integer is 6",
                rdChecker.displayLargestAndSmallestInteger());
    }
}
