package play;


public class StringManipulator {

    public String removeCharactersOfStringTwoInStringOne(String stringOne, String stringTwo) {
        StringBuilder newString = new StringBuilder();
        for(int index = 0; index < stringOne.length(); index++){
            if (characterNotContainedInStringTwo(String.valueOf(stringOne.charAt(index)), stringTwo)) newString.append(stringOne.charAt(index));
        }
        return newString.toString();
    }

    private boolean characterNotContainedInStringTwo(String c, String stringTwo) {
        for(int index = 0; index < stringTwo.length(); index++){
            if(c.equalsIgnoreCase(Character.toString(stringTwo.charAt(index)))) return false;
        }
        return true;
    }
}
