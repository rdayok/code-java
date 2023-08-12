package Chapter2Test;

import Chapter2.CountNegativePositiveZeroNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNegativePositiveZeroNumbersTest {
    @Test public void countNegativePositiveZeroNumbersTest1(){
        CountNegativePositiveZeroNumbers rdCountObject = new CountNegativePositiveZeroNumbers();
        rdCountObject.countPositiveNegativeZeroNumbers(434);
        rdCountObject.countPositiveNegativeZeroNumbers(-566);
        rdCountObject.countPositiveNegativeZeroNumbers(-5);
        rdCountObject.countPositiveNegativeZeroNumbers(0);
        rdCountObject.countPositiveNegativeZeroNumbers(0);
        assertEquals("2 zero, 2 negative and 1 positive numbers",
                rdCountObject.getCountOfPositiveNegativeZeroNumber());
    }
    @Test public void countNegativePositiveZeroNumbersTest2(){
        CountNegativePositiveZeroNumbers rdCountObject = new CountNegativePositiveZeroNumbers();
        rdCountObject.countPositiveNegativeZeroNumbers(43);
        rdCountObject.countPositiveNegativeZeroNumbers(5);
        rdCountObject.countPositiveNegativeZeroNumbers(-554);
        rdCountObject.countPositiveNegativeZeroNumbers(-43);
        rdCountObject.countPositiveNegativeZeroNumbers(0);
        assertEquals("1 zero, 2 negative and 2 positive numbers",
                rdCountObject.getCountOfPositiveNegativeZeroNumber());
    }
}
