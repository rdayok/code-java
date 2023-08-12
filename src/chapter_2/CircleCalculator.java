package chapter_2;

public class CircleCalculator {
    private int diameterOfACircle;
    private double circumferenceOfACircle;
    private double areaOfACircle;
    public final int TWO = 2;

    public void calculateDiameterOfACircle(int radius) {
        diameterOfACircle =  TWO * radius;
    }

    public double getDiameterOfACircle() {
        return diameterOfACircle;
    }

    public void calculateCircumferenceOfCircle(int radius) {
        circumferenceOfACircle =  (TWO * Math.PI * radius);
    }

    public double getCircumferenceOfACircle() {
        return circumferenceOfACircle;
    }

    public void calculateAreaOfACircle(int radius) {
        areaOfACircle = (float) (Math.PI * (Math.pow(radius, TWO)));
    }

    public double getAreaOfACircle() {
        return areaOfACircle;
    }
}
