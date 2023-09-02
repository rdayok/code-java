package chapter_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetrolTest {
    private PetrolPurchase petrolPurchase = new PetrolPurchase("Yaba", "Gasoline",
            50, 125.65, 43.7);

    @Test
    public void testPetrolExist(){
        assertNotNull(petrolPurchase);
    }

    @Test
    public void testGettingTheTypeOfPetrol(){
        String expectedTypeOfPetrol = "Gasoline";
        assertEquals(expectedTypeOfPetrol, petrolPurchase.getPetrolType());
    }

    @Test
    public void testSettingThePetrolType(){
        String expectedTypeOfPetrol = "Kerosene";
        petrolPurchase.setPetrolType("Kerosene");
        assertEquals(expectedTypeOfPetrol, petrolPurchase.getPetrolType());
    }

    @Test
    public void testGettingThePetrolStation(){
        String expectedPetrolStation = "Yaba";
        assertEquals(expectedPetrolStation, petrolPurchase.getPetrolStation());
    }

    @Test
    public void testSettingThePetrolStation(){
        String expectedPetrolStation = "Jos";
        petrolPurchase.setPetrolStation("Jos");
        assertEquals(expectedPetrolStation, petrolPurchase.getPetrolStation());
    }

    @Test
    public void testGettingPetrolQuantity(){
        int expectedPetrolStation = 50;
        assertEquals(expectedPetrolStation, petrolPurchase.getPetrolQuantity());
    }

    @Test
    public void testSettingPetrolQuantity(){
        int expectedPetrolQuantity = 100;
        petrolPurchase.setPetrolQuantity(100);
        assertEquals(expectedPetrolQuantity, petrolPurchase.getPetrolQuantity());
    }

    @Test
    public void testGettingPriceOfPetrol(){
        double expectedPriceOfPetrolPerLiter = 125.65;
        assertEquals(expectedPriceOfPetrolPerLiter, petrolPurchase.getPriceOfPetrolPerLiter());
    }

    @Test
    public void testSettingPriceOfPetrolPerLiter(){
        double expectedPriceOfPetrolPerLiter = 320.4;
        petrolPurchase.setPetrolPricePerLiter(320.4);
        assertEquals(expectedPriceOfPetrolPerLiter, petrolPurchase.getPriceOfPetrolPerLiter());
    }

    @Test
    public void testGettingPercentageDiscount(){
        double expectedPercentageDiscount = 43.7;
        assertEquals(expectedPercentageDiscount, petrolPurchase.getPercentageDiscountOfPetrolPurchase());
    }

    @Test
    public void testSettingPercentageDiscountOfPetrolPurchase(){
        double expectedPercentageDiscountOfPetrolDiscount = 32.1;
        petrolPurchase.setPercentageDiscountOfPetrolPurchase(32.1);
        assertEquals(expectedPercentageDiscountOfPetrolDiscount,
                petrolPurchase.getPercentageDiscountOfPetrolPurchase());
    }

    @Test
    public void testCalculatingThePurchasingAmountOfPetrol(){
        double expectedPurchasingAmountOfPetrol = 3_537.05;
        assertEquals(expectedPurchasingAmountOfPetrol, petrolPurchase.calculatePetrolPurchaseAmount());
    }

    @Test
    public void testCalculatingThePurchasingAmountOfPetrol2(){
        petrolPurchase.setPetrolQuantity(70);
        double expectedPurchasingAmountOfPetrol = 4951.87;
        assertEquals(expectedPurchasingAmountOfPetrol, petrolPurchase.calculatePetrolPurchaseAmount());
    }
}
