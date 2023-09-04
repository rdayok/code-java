package chapter_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecryptionCryptographerTest {
    DecryptionCryptographer decryptionCryptographer = new DecryptionCryptographer();
    private String inputtedFourDigitNumber = "2389";


    @Test
    public void testDecrypterIsNotNull() {
        assertNotNull(decryptionCryptographer);
    }


    @Test
    public void testDecrypterCanReadFourDigitNumber() {
        decryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        assertEquals(inputtedFourDigitNumber, decryptionCryptographer.getDecryptedInput());
    }

    @Test
    public void testDecrypterCanReadNumberStartingWithZero() {
        String inputtedFourDigitNumber = "0346";
        decryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        assertEquals(inputtedFourDigitNumber, decryptionCryptographer.getDecryptedInput());
    }

    @Test
    public void testUserCannotEnterANumberWithMoreThanFourDigits() {
        String inputtedFourDigitNumber = "008554";
        assertThrows(IllegalArgumentException.class, () -> decryptionCryptographer.readUserInputOf(inputtedFourDigitNumber));
    }

    @Test
    public void testUserCannotEnterANumberWithAlphabets() {
        String inputtedFourDigitNumber = "8r54";
        assertThrows(IllegalArgumentException.class, () -> decryptionCryptographer.readUserInputOf(inputtedFourDigitNumber));
    }

    @Test
    public void testSwappingTheDigitsOfTheGottenEncryptedNumber() {
        String expectedOutOutput = "8923";
        decryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        decryptionCryptographer.swapDigitsOfEncryptedNumber();
        assertEquals(expectedOutOutput, decryptionCryptographer.getDecryptedInput());
    }

    @Test
    public void testCryptographerCanDecryptEnteredNumber() {
        String expectedOutOutput ="1256";
        decryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        decryptionCryptographer.swapDigitsOfEncryptedNumber();
        decryptionCryptographer.decryptUserInput();
        assertEquals(expectedOutOutput, decryptionCryptographer.getDecryptedInput());
    }


}
