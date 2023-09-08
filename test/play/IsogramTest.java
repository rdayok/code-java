package play;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsogramTest {

    Isogram isogram = new Isogram();


    @Test
    public void testIsoGramIsNotNull() {
        assertNotNull(isogram);
    }

    @Test
    public void testInputDoesntContainNumbers() {
        String userInput = "qwertyuioplkjhgfdsazxcvbn8";
        assertFalse(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testInputDoesntContainSymbols() {
        String userInput = "asdfghjklmnbvcxzqwertyuio-";
        assertFalse(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testInput_returnsFalse() {
        String userInput = "JohnJonesuijhgtfredswqaxcv";
        assertFalse(isogram.checkIfAnIsogramFor(userInput));
    }
    @Test
    public void testInput_returnsTrues() {
        String userInput = "Asdfghjklmnbvcxzqwertyuiop";
        assertTrue(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testInput_returnsFalseForInputWithLengthLessThanTwentySix() {
        String userInput = "Johnjones";
        assertFalse(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testInput_returnsTrueEvenWithSpace() {
        String userInput = "As dfgh jklmn bvcxz qwertyuiop";
        assertTrue(isogram.checkIfAnIsogramFor(userInput));
    }

}
