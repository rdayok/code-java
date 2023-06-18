package play;

public class StripDigitsFromString {
    private static String number = "";
    public static void main(String[] args) {
        String input = "ree4 g46h7]9";
        stripOtherThanDigit(input);
        System.out.println("this is the number formed from the input "+ number);
    }

    private static void stripOtherThanDigit(String input) {
        for (int index = 0; index < input.length(); index++) concatenateFoundDigits(input.charAt(index));
    }

    private static void concatenateFoundDigits(char selectedCharacter) {
        boolean isDigit = Character.isDigit(selectedCharacter);
        if(isDigit) number += selectedCharacter;
    }
}
