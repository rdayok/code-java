package chapter_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BMICalculatorTest {

    BMICalculator rdBMIcalculator = new BMICalculator();
    @Test public void calculateBMITest1(){
        rdBMIcalculator.calculateBMI(72, 1.65);
        rdBMIcalculator.setBMICategories();
        assertEquals(26.45, rdBMIcalculator.getBMI());
        assertEquals("With BMI of 26.45, you are overweight", rdBMIcalculator.getBMICategories());
    }
    @Test public void calculateBMITest2(){
        rdBMIcalculator.calculateBMI(90, 1.4);
        rdBMIcalculator.setBMICategories();
        assertEquals(45.92, rdBMIcalculator.getBMI());
        assertEquals("With BMI of 45.92, you are obese", rdBMIcalculator.getBMICategories());
    }
    @Test public void calculateBMITest3(){
        rdBMIcalculator.calculateBMI(50.0, 1.5);
        rdBMIcalculator.setBMICategories();
        assertEquals(22.22, rdBMIcalculator.getBMI());
        assertEquals("With BMI of 22.22, you are normal", rdBMIcalculator.getBMICategories());
    }
    @Test public void calculateBMITest4(){
        rdBMIcalculator.calculateBMI(35,1.7);
        rdBMIcalculator.setBMICategories();
        assertEquals(12.11, rdBMIcalculator.getBMI());
        assertEquals("With BMI of 12.11, you are underweight", rdBMIcalculator.getBMICategories());
    }

}
