package Chapter2;
/* 2.34 (World Population Growth Calculator) Search the Internet to determine the current
world population and the annual world population growth rate. Write an application that
inputs these values, then displays the estimated world population after one, two, three,
four and five years. Formula for population growth N = P * (1 + r/100)^t*/

public class WorldPopulationGrowthCalculator {
    private double populationGrowth;
    public final double ONE_HUNDRED = 100;
    public final double ONE = 1;

    public void calculatePopulationGrowth(long currentPopulation, int years, double populationGrowthRate) {
        double populationGrowth = currentPopulation * (Math.pow((ONE + populationGrowthRate), years));
        this.populationGrowth = Math.round(populationGrowth * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public double getPopulation() {
        return populationGrowth;
    }
}
