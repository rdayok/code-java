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
    public void testForInputThatContainNumber() {
        String userInput = "asdf22gh4jklmnbv998cx2zqwertyuiop8";
        assertTrue(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testForInputWithSpecialCharacters() {
        String userInput = "asdfgh<jklzxcvbnmq>wertyuiop-";
        assertTrue(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testForInputWithSpaces() {
        String userInput = "asdfg hjklz xcvb nmq wertyuiop";
        assertTrue(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testForInputWithLowerCaseAndUpperCase() {
        String userInput = "Asdfghjklmnbvcxzqwertyuioa";
        assertFalse(isogram.checkIfAnIsogramFor(userInput));
    }

    @Test
    public void testForInputWithoutSomeAlphabets() {
        String userInput = "Johnjones";
        assertFalse(isogram.checkIfAnIsogramFor(userInput));
    }

}
