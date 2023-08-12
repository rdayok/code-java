package Chapter2Test;


import Chapter2.StatisticsOFPyramidOfGiza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatOFPyramidOfGizaTest {
    StatisticsOFPyramidOfGiza rdPyramidObject = new StatisticsOFPyramidOfGiza();
    @Test public void calculateWeightOfPyramidBuiltInAYearTest(){
        rdPyramidObject.calculateWeightOfPyramidBuiltInAYear(2_300_000,
                2.5, 20);
        assertEquals(287500.0, rdPyramidObject.getPyramidWeightBuiltInAYear());
    }
    @Test public void calculateWeightOfPyramidBuiltInAnHourTest(){
        rdPyramidObject.calculateWeightOfPyramidBuiltInAYear(2_300_000,
                2.5, 20);
        rdPyramidObject.calculateWeightOfPyramidBuiltInAnHour();
        assertEquals(32.82, rdPyramidObject.getPyramidWeightBuiltInHours());
    }
    @Test public void calculateWeightOfPyramidBuiltInAMinuteTest(){
        rdPyramidObject.calculateWeightOfPyramidBuiltInAYear(2_300_000,
                2.5, 20);
        rdPyramidObject.calculateWeightOfPyramidBuiltInAnHour();
        rdPyramidObject.calculateWeightOfPyramidBuiltInAMinute();
        assertEquals(0.55, rdPyramidObject.getPyramidWeightBuiltInAMinute());
    }

}