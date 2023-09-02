package chapter_2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiveDigitNumberSeparatorTest {

    @Test public void fiveDigitNumberSeparatorTest1(){
        FiveDigitNumberSeparator rdDigitSeparator = new FiveDigitNumberSeparator();
        rdDigitSeparator.separateDigits(46675);
        assertEquals("4   6   6   7   5", rdDigitSeparator.getSeparatedDigits());
    }
    @Test public void fiveDigitNumberSeparatorTest2(){
        FiveDigitNumberSeparator rdDigitSeparator = new FiveDigitNumberSeparator();
        rdDigitSeparator.separateDigits(83522);
        assertEquals("8   3   5   2   2", rdDigitSeparator.getSeparatedDigits());
    }
    @Test public void testForMoreThanFiveDigitNumber(){
        FiveDigitNumberSeparator rdDigitSeparator = new FiveDigitNumberSeparator();
        rdDigitSeparator.separateDigits(835224);
        assertEquals("", rdDigitSeparator.getSeparatedDigits());
    }
    @Test public void testForLessThanFiveDigitNumber(){
        FiveDigitNumberSeparator rdDigitSeparator = new FiveDigitNumberSeparator();
        rdDigitSeparator.separateDigits(8352);
        assertEquals("", rdDigitSeparator.getSeparatedDigits());
    }
}
