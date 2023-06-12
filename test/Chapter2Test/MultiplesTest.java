package Chapter2Test;


import Chapter2.Multiples;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplesTest {
    Multiples rdMultiples = new Multiples();
    @Test public void multiplesTest1(){
        rdMultiples.multiplesChecker(4, 24);
        assertTrue(rdMultiples.isTripledFirstIntegerMultipleOfDoubledSecondInteger());
    }
    @Test public void multiplesTest2(){
        rdMultiples.multiplesChecker(4, 15);
        assertFalse(rdMultiples.isTripledFirstIntegerMultipleOfDoubledSecondInteger());
    }
    @Test public void multiplesTest3(){
        rdMultiples.multiplesChecker(3, 15);
        assertFalse(rdMultiples.isTripledFirstIntegerMultipleOfDoubledSecondInteger());
    }
}
