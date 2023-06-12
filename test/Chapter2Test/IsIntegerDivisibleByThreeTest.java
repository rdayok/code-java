package Chapter2Test;


import Chapter2.IsIntegersDivisibleByThree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class IsIntegerDivisibleByThreeTest {
    IsIntegersDivisibleByThree isDivisibleByThree = new IsIntegersDivisibleByThree();
    @Test public void isDivisibleByThreeTest1(){
        isDivisibleByThree.isDivisibleByThree(64);
        assertFalse(isDivisibleByThree.isDivisibleByThree());
    }
    @Test public void isDivisibleByThreeTest2(){
        isDivisibleByThree.isDivisibleByThree(9);
        assertTrue(isDivisibleByThree.isDivisibleByThree());
    }
    @Test public void isDivisibleByThreeTest3(){
        isDivisibleByThree.isDivisibleByThree(-21);
        assertTrue(isDivisibleByThree.isDivisibleByThree());
    }
}
