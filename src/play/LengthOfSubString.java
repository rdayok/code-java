package play;

import java.util.ArrayList;

public class LengthOfSubString {
    public static void main(String[] args) {
        String userInput = "pp";
        int result = lengthOfSubString(userInput);
        System.out.println(result);
    }

    private static int lengthOfSubString(String inputtedString) {
        ArrayList<Character> characters = new ArrayList<>();
        int lengthOfSubString = 0;
        if (inputtedString.isEmpty()) return 0;
        for(int index = 0; index < inputtedString.length(); index++){
            characters.add(inputtedString.charAt(index));
            for(int index2 = index; index2 < inputtedString.length(); index2++){
                if((index2 + 1) == inputtedString.length() ) {
                    if (lengthOfSubString < characters.size()) lengthOfSubString = characters.size();
                    characters.clear();
                    break;
                }
                if (!characters.contains(inputtedString.charAt(index2 + 1))) characters.add(inputtedString.charAt(index2 + 1));
                else {
                    if (lengthOfSubString < characters.size()) lengthOfSubString = characters.size();
                    characters.clear();
                    break;
                }
            }
        }
        return lengthOfSubString;
    }
}
