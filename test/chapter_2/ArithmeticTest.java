package chapter_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticTest {
    Arithmetic arithmetic = new Arithmetic();
    @Test public void squareRootTest(){
        arithmetic.squareRoots(3, 4);
        assertEquals("Square root of first integer is : " +
                "9 and for second integer is : 16", arithmetic.getResult());
    }
    @Test public void sumSquareRootTest(){
        arithmetic.sumOfSquareRoots(2, 4);
        assertEquals("The sum of the square roots of the two integers is: 20",
                arithmetic.getResult());
    }
    @Test public void differenceOfSquareRoots(){
        arithmetic.differenceOfSquareRoots(5, 4);
        assertEquals("The difference of the square roots of the two integers is: 9", arithmetic.getResult());
    }
    @Test public void differenceOfSquareRoots2(){
        arithmetic.differenceOfSquareRoots(4, 5);
        assertEquals("You entered a second integer less than the first", arithmetic.getResult());
    }
}