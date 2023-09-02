package chapter_2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleCalculatorTest {
    CircleCalculator rdCircleCalculator = new CircleCalculator();
    @Test public void calculateDiameterOfACircleTest(){
        rdCircleCalculator.calculateDiameterOfACircle(4);
        assertEquals(8,rdCircleCalculator.getDiameterOfACircle());
    }
    @Test public void calculateCircumferenceOfACircleTest(){
        rdCircleCalculator.calculateCircumferenceOfCircle(4);
        assertEquals(25.132741228718345,rdCircleCalculator.getCircumferenceOfACircle());
    }
    @Test public void calculateAreaOfACircleTest(){
        rdCircleCalculator.calculateAreaOfACircle(4);
        assertEquals(50.26548385620117,rdCircleCalculator.getAreaOfACircle());
    }
}
