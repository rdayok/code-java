package classtacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MultiplicationWithOutAsteriskTest {
    MultiplicationWithoutAsterisk calculator = new MultiplicationWithoutAsterisk();
    @Test public void testCalculatorObjectExit(){
        assertNotNull(calculator);
    }
    @Test public void testCalculatorCanReturnProduct(){
        assertEquals(12, calculator.product(3, 4));
    }
    @Test public void testMultiplicationWithZero(){
        assertEquals(0, calculator.product(6, 0));
    }
    @Test public void testMultiplicationWithNegativeValue(){
        assertEquals(-6, calculator.product(3, -2));
    }

    @Test public void testMultiplicationWithNegativeValue2(){
        assertEquals(-9, calculator.product(-3, 3));
    }

    @Test public void testMultiplicationWithTwoNegativeNumbers(){
        assertEquals(24, calculator.product(-6, -4));
    }
}
