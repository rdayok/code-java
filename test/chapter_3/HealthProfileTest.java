package chapter_3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HealthProfileTest {
    private String firstName = "Retnaa";
    private String lastName = "Dayok";
    private String sex = "Male";
    private LocalDate dateOfBirth = LocalDate.of(1989, 9, 8);
    private double heightInInches = 64.96;
    private double weightInPounds = 158.74;

    private HealthProfile healthProfile = new HealthProfile(firstName, lastName, sex, dateOfBirth, heightInInches, weightInPounds);

    @Test
    public void testHealthProfileObjectIsNotNull() {
        assertNotNull(healthProfile);
    }

    @Test
    public void testCalculateUserAge_returnsActualAge() {
        int expectedAgeOfUser = 34;
        assertEquals(expectedAgeOfUser, healthProfile.calculateAgeOfUser());
    }

    @Test
    public void testMaxHeatRateCalculator_returnsActualMaxHeatRate() {
        int expectedMaxHearRate = 186;
        assertEquals(expectedMaxHearRate, healthProfile.calculateMaxHeartRate());
    }

    @Test
    public void testRangeOfTargetHeartRate_returnsActualRangeForMaxHeartRate() {
        String expectedRangeOfTargetHeartRate = "93.00-158.10";
        assertEquals(expectedRangeOfTargetHeartRate, healthProfile.calculateMaxHeartRateRange());
    }

    @Test
    public void testBMICalculator_returnsActualBMI_values() {
        var expectedBMI = 26.45;
        assertEquals(expectedBMI, healthProfile.calculateUserBMI());
    }

    @Test
    public void testHealthProfile_returnsHealthDetailsOfUser() {
        String expectedDetailsOfUserHealthProfile = """
                Retnaa Dayok
                Date of Birth: 1989-09-08
                Sex: Male
                Height in Inches: 64.96
                Weight in Pounds: 158.74
                BMI: 26.45
                """;

        assertEquals(expectedDetailsOfUserHealthProfile, healthProfile.getUserHealthDetails());
    }

}
