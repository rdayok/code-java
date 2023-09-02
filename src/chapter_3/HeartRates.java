package chapter_3;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HeartRates {

    private String firstName;

    private String lastName;
    private final LocalDate dateOfBirth;
    private final DecimalFormat decimal = new DecimalFormat("0.0");


    public HeartRates(String firstName, String lastName,
                      LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("""
                firstName: %s
                lastName: %s
                dateOfBirth: %s
                """, firstName, lastName, dateOfBirth.toString());
    }

    public int calculateAgeOfPerson() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear() - dateOfBirth.getYear();
    }

    public int calculateMaxHeartRateOfPerson() {
        return 220 - calculateAgeOfPerson();
    }

    public String calculateRangeOfMaxHeatRate() {
        int maxHeartRate = calculateMaxHeartRateOfPerson();
        double fiftyPercent = 0.5;
        double eightyFivePercent = 0.85;
        double leastTargetHeartRate = maxHeartRate * fiftyPercent;
        double maxTargetHeartRate = maxHeartRate * eightyFivePercent;
        return decimal.format(leastTargetHeartRate) + "-" + decimal.format(maxTargetHeartRate);
    }
}
