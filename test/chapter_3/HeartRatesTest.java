package chapter_3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.Month.SEPTEMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HeartRatesTest {

    private String firstName = "Jay";
    private String lastName = "Don";
    private LocalDate dateOfBirth = LocalDate.of(1989, SEPTEMBER, 8);

    private HeartRates heartRates = new HeartRates(firstName, lastName, dateOfBirth);


    @Test
    public void testCreatedClassInstanceIsNotNull() {
        assertNotNull(heartRates);
    }


    @Test
    public void testHeartRatesConstructor_initializesStatesOfAnInstance() {
        String expectedObject = """
                firstName: Jay
                lastName: Don
                dateOfBirth: 1989-09-08
                """;
        assertEquals(expectedObject, heartRates.toString());
    }

    @Test
    public void testAgeCalculator_returnsUserAge() {
        int expectedAge = 34;
        assertEquals(expectedAge, heartRates.calculateAgeOfPerson());
    }

    @Test
    public void testMaxHeartRateCalculator_returnsMaxHeartRateOfPerson() {
        int expectedMaxHeartRateOfPerson = 186;
        assertEquals(expectedMaxHeartRateOfPerson, heartRates.calculateMaxHeartRateOfPerson());
    }

    @Test
    public void testTargetHeartRateCalculator_returnsTheTargetRateForA_person() {
        String expectedRangeOfTargetHearRate = "93.0-158.1";
        assertEquals(expectedRangeOfTargetHearRate, heartRates.calculateRangeOfMaxHeatRate());
    }
}
