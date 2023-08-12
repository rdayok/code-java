package Chapter2Test;


import Chapter2.WorldPopulationGrowthCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldPopulationGrowthCalculatorTest {
    WorldPopulationGrowthCalculator rdObject = new WorldPopulationGrowthCalculator();
    @Test public void calculatePopulationAfterOneYearTest(){
        rdObject.calculatePopulationGrowth(8_000_000_000L, 1, 0.009);
        assertEquals(8_072_000_000L, rdObject.getPopulation());
    }
    @Test public void calculatePopulationAfterTwoYearsTest(){
        rdObject.calculatePopulationGrowth(8_000_000_000L, 2, 0.009);
        assertEquals(8_144_648_000L, rdObject.getPopulation());
    }
    @Test public void calculatePopulationAfterThreeYearsTest(){
        rdObject.calculatePopulationGrowth(8_000_000_000L, 3, 0.009);
        assertEquals(8_217_949_832L, rdObject.getPopulation());
    }
    @Test public void calculatePopulationAfterFourYearsTest(){
        rdObject.calculatePopulationGrowth(8_000_000_000L, 4, 0.009);
        assertEquals(8_291_911_380.49D, rdObject.getPopulation());
    }
    @Test public void calculatePopulationAfterFiveYearsTest(){
        rdObject.calculatePopulationGrowth(8_000_000_000L, 5, 0.009);
        assertEquals(8_366_538_582.91D, rdObject.getPopulation());
    }
}
