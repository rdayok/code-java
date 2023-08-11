package play;

import java.util.ArrayList;

public class HighestOccurringCharacter {
    public String getTheHighestOccurringCharacterIn(String inputtedString) {
        ArrayList<String> countedCharacters = new ArrayList<>();
        int counterForEachSelectedCharacter = 0;
        String theHighestOccurringCharacter = "";
        for(int index = 0; index < inputtedString.length(); index++){
            int selecterCharacterCounter = 0;
            boolean isCharacterThatHasNotBeenCounted = !countedCharacters.contains(String.valueOf(inputtedString.charAt(index)));
            if(isCharacterThatHasNotBeenCounted){
                for(int index2 = 0; index2 < inputtedString.length(); index2++)
                    if(String.valueOf(inputtedString.charAt(index)).equalsIgnoreCase(String.valueOf(inputtedString.charAt(index2)))) selecterCharacterCounter += 1;
                boolean isTheMostOccurringCharacterNow = selecterCharacterCounter > counterForEachSelectedCharacter;
                if(isTheMostOccurringCharacterNow){
                    counterForEachSelectedCharacter = selecterCharacterCounter;
                    theHighestOccurringCharacter = String.valueOf(inputtedString.charAt(index));
                }
            }
            countedCharacters.add(String.valueOf(inputtedString.charAt(index)));

        }
        return theHighestOccurringCharacter;
    }
}
