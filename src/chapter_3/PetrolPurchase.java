package chapter_3;

import java.text.DecimalFormat;

public class PetrolPurchase {

    private double priceOfPetrolPerLiter;
    private int quantityOfPetrolInLiter;
    private String typeOfPetrol;
    private String petrolStation;
    private double percentageDiscountOfPetrolPurchase;
    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public PetrolPurchase(String petrolStation, String typeOfPetrol, int quantityOfPetrolInLiter,
                          double priceOfPetrolPerLiter, double percentageDiscountOfPetrolPurchase) {
        this.typeOfPetrol = typeOfPetrol;
        this.petrolStation = petrolStation;
        this.quantityOfPetrolInLiter = quantityOfPetrolInLiter;
        this.priceOfPetrolPerLiter = priceOfPetrolPerLiter;
        this.percentageDiscountOfPetrolPurchase = percentageDiscountOfPetrolPurchase;
    }

    public void setPetrolType(String typeOfPetrol) {
        this.typeOfPetrol = typeOfPetrol;
    }

    public String getPetrolType() {
        return typeOfPetrol;
    }

    public String getPetrolStation() {
        return petrolStation;
    }

    public void setPetrolStation(String petrolStation) {
        this.petrolStation = petrolStation;
    }

    public int getPetrolQuantity() {
        return quantityOfPetrolInLiter;
    }

    public void setPetrolQuantity(int quantityOfPetrol) {
        this.quantityOfPetrolInLiter = quantityOfPetrol;
    }

    public double getPriceOfPetrolPerLiter() {
        return priceOfPetrolPerLiter;
    }

    public void setPetrolPricePerLiter(double priceOfPetrolPerLiter) {
        this.priceOfPetrolPerLiter = priceOfPetrolPerLiter;
    }

    public double getPercentageDiscountOfPetrolPurchase() {
        return percentageDiscountOfPetrolPurchase;
    }

    public void setPercentageDiscountOfPetrolPurchase(double percentageDiscountOfPetrolPurchase) {
        this.percentageDiscountOfPetrolPurchase = percentageDiscountOfPetrolPurchase;
    }

    public double calculatePetrolPurchaseAmount() {
        double costOfPetrolPurchase = priceOfPetrolPerLiter * quantityOfPetrolInLiter;
        double discountedPriceOfPetrolPurchase = costOfPetrolPurchase * (percentageDiscountOfPetrolPurchase / 100);
        double purchaseAmount =costOfPetrolPurchase - discountedPriceOfPetrolPurchase;
        return Double.parseDouble(decimalFormat.format(purchaseAmount));
    }
}
