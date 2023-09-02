package chapter_2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareIntegerTest {
    CompareInteger compare = new CompareInteger();
    @Test public void compareIntegerLessThanAHundred(){
        compare.compareIntegerToHundred(65);
        assertEquals("Integer 65 is less than 100",
                compare.getIntegerCharacteristics());
    }
    @Test public void compareIntegerAboveAHundred(){
        compare.compareIntegerToHundred(146);
        assertEquals("Integer 146 is greater than 100",
                compare.getIntegerCharacteristics());
    }
    @Test public void compareIntegerToAHundred(){
        compare.compareIntegerToHundred(100);
        assertEquals("Integer 100 is equal to 100",
                compare.getIntegerCharacteristics());
    }
    @Test public void compareIntegerSquareLessThanAHundred(){
        compare.compareSquaredIntegerToHundred(9);
        assertEquals("Integer 9 square is less than 100",
                compare.getIntegerCharacteristics());
    }
    @Test public void compareIntegerSquareAboveAHundred(){
        compare.compareSquaredIntegerToHundred(146);
        assertEquals("Integer 146 square is greater than 100",
                compare.getIntegerCharacteristics());
    }
    @Test public void compareIntegerSquareToAHundred(){
        compare.compareSquaredIntegerToHundred(10);
        assertEquals("Integer 10 square is equal to 100",
                compare.getIntegerCharacteristics());
    }

}
