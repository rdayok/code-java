package chapter_2;
/*2.35 (Statistics for the Great Pyramid of Giza) The Great Pyramid of Giza is considered
an engineering marvel of its time. Use the web to get statistics related to the Great Pyramid
of Giza, and find the estimated number of stones used to build it, the average weight of each
stone, and the number of years it took to build. Create an application that calculates an
estimate of how much, by weight, of the pyramid was built each year, each hour, and each minute
as it was being built. The application should input the following information:
        a) Estimated number of stones used.
        b) Average weight of each stone.
        c) Number of years taken to build the pyramid (assuming a year comprises 365 days).
It took 100_000 men 20 years to build.
Estimated average weight of each stone was 2.5 tons
365 days in a year
        */

public class StatisticsOFPyramidOfGiza {

    private double pyramidWeightBuiltInAYear;
    private double pyramidWeightBuiltInAnHour;
    private double pyramidWeightBuiltInAMinute;
    public final Double ONE_HUNDRED = 100.0;
    public final int HOURS_PER_YEAR = 365 * 24;
    public final int MINUTES_PER_HOUR = 60;

    public void calculateWeightOfPyramidBuiltInAYear(int numberOfStonesForPyramid, double averageWeightOfPyramidStones, int yearsItTookToBuildPyramid) {
        pyramidWeightBuiltInAYear = (numberOfStonesForPyramid * averageWeightOfPyramidStones) / yearsItTookToBuildPyramid;
    }

    public double getPyramidWeightBuiltInAYear() {
        return pyramidWeightBuiltInAYear;
    }

    public void calculateWeightOfPyramidBuiltInAnHour() {
        pyramidWeightBuiltInAnHour = Math.round((pyramidWeightBuiltInAYear / HOURS_PER_YEAR) * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public double getPyramidWeightBuiltInHours() {
        return pyramidWeightBuiltInAnHour;
    }

    public void calculateWeightOfPyramidBuiltInAMinute() {
        pyramidWeightBuiltInAMinute = Math.round((pyramidWeightBuiltInAnHour / MINUTES_PER_HOUR) * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public double getPyramidWeightBuiltInAMinute() {
        return pyramidWeightBuiltInAMinute;
    }
}