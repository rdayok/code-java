package chapter_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncryptionCryptographerTest {
    EncryptionCryptographer encryptionCryptographer = new EncryptionCryptographer();
    private String inputtedFourDigitNumber = "1256";


    @Test
    public void testCryptographerIsNotNull() {
        assertNotNull(encryptionCryptographer);
    }

    @Test
    public void testCryptographerCanReadFourDigitNumber() {
        encryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        assertEquals(inputtedFourDigitNumber, encryptionCryptographer.getEncryptedInput());
    }

    @Test
    public void testCryptographerCanReadNumberStartingWithZero() {
        String inputtedFourDigitNumber = "0346";
        encryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        assertEquals(inputtedFourDigitNumber, encryptionCryptographer.getEncryptedInput());
    }

    @Test
    public void testUserCannotEnterANumberWithMoreThanFourDigits() {
        String inputtedFourDigitNumber = "008554";
        assertThrows(IllegalArgumentException.class, () -> encryptionCryptographer.readUserInputOf(inputtedFourDigitNumber));
    }

    @Test
    public void testUserCannotEnterANumberWithAlphabets() {
        String inputtedFourDigitNumber = "8r54";
        assertThrows(IllegalArgumentException.class, () -> encryptionCryptographer.readUserInputOf(inputtedFourDigitNumber));
    }

    @Test
    public void testCryptographerCanEncryptEnteredNumber() {
        String expectedOutOutput ="8923";
        encryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        encryptionCryptographer.encryptDigits();
        assertEquals(expectedOutOutput, encryptionCryptographer.getEncryptedInput());
    }

    @Test
    public void testSwappingTheDigitsOfTheGottenNumberAfterEncrypting() {
        String expectedOutOutput = "2389";
        encryptionCryptographer.readUserInputOf(inputtedFourDigitNumber);
        encryptionCryptographer.encryptDigits();
        encryptionCryptographer.swapDigitsOfEncryptedNumber();
        assertEquals(expectedOutOutput, encryptionCryptographer.getEncryptedInput());
    }

}
