package Chapter2;

public class BMICalculator {
    public final double ONE_HUNDRED = 100;
    public final int ZERO = 0;
    public final double BMI_MIN_NORMAL_WEIGHT = 18.5;
    public final double BMI_MAX_NORMAL_WEIGHT = 24.9;
    public final double BMI_MIN_0VER_WEIGHT = 25.0;
    public final double BMI_MAX_0VER_WEIGHT = 29.9;

    public String BMICategories;
    private double BMI;

    public void calculateBMI(double weightInKilograms, double heightInMeters) {
        if (weightInKilograms > ZERO && heightInMeters > ZERO) {
            double bmi = weightInKilograms / (heightInMeters * heightInMeters);
            BMI = Math.round(bmi * ONE_HUNDRED) / ONE_HUNDRED;
        }
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMICategories() {
        if (BMI < BMI_MIN_NORMAL_WEIGHT) BMICategories = "With BMI of "+ BMI +", you are underweight";
        else if (BMI >= BMI_MIN_NORMAL_WEIGHT && BMI <= BMI_MAX_NORMAL_WEIGHT) BMICategories = "With BMI of "+
                BMI +", you are normal";
        else if (BMI >= BMI_MIN_0VER_WEIGHT && BMI <= BMI_MAX_0VER_WEIGHT) BMICategories = "With BMI of "+
                BMI +", you are overweight";
        else BMICategories = "With BMI of "+ BMI +", you are obese";
    }

    public String getBMICategories() {
        return BMICategories;
    }
}
