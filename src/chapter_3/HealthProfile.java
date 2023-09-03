package chapter_3;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private final String sex;
    private final LocalDate dateOfBirth;
    private double heightInInches;
    private double weightInPounds;
    private DecimalFormat decimal = new DecimalFormat("0.00");

    public HealthProfile(String firstName, String lastName,
                         String sex, LocalDate dateOfBirth,
                         double heightInInches, double weightInPounds)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public int calculateAgeOfUser() {
        LocalDate todayDate = LocalDate.now();
        return todayDate.getYear() - dateOfBirth.getYear();
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAgeOfUser();
    }

    public String calculateMaxHeartRateRange() {
        double leastPercentageOfMaxHeartRate = 0.5;
        double maxPercentageOfMaxHeartRate = 0.85;
        Double leastTargetHeartRate = calculateMaxHeartRate() * leastPercentageOfMaxHeartRate;
        Double maxTargetHeartRate = calculateMaxHeartRate() * maxPercentageOfMaxHeartRate;
        return decimal.format(leastTargetHeartRate) + "-" + decimal.format(maxTargetHeartRate);
    }

    public double calculateUserBMI() {
        double bmi = (weightInPounds * 703 )/ (heightInInches * heightInInches);
        return Math.round(bmi * 100) / 100.0;
    }

    public String getUserHealthDetails() {
        return String.format("""
                %s %s
                Date of Birth: %S
                Sex: %s
                Height in Inches: %s
                Weight in Pounds: %s
                BMI: %s
                """, firstName, lastName, dateOfBirth.toString(), sex, decimal.format(heightInInches), decimal.format(weightInPounds), decimal.format(calculateUserBMI()));
    }
}
