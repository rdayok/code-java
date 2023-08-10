package play;

public class HighestOccurringCharacter {
    public String getTheHighestOccurringCharacterIn(String s) {
        int selecterCharacterCounter = 0;
        int countOTheHighestOccurringCharacter = 0;
        String theHighestOccurringCharacter = "";
        for(int index = 0; index < s.length(); index++){
            for(int index2 = 0; index2 < s.length(); index2++){
                if(String.valueOf(s.charAt(index)).equalsIgnoreCase(String.valueOf(s.charAt(index2)))) selecterCharacterCounter += 1;
            }
            if(selecterCharacterCounter > countOTheHighestOccurringCharacter){
                countOTheHighestOccurringCharacter = selecterCharacterCounter;
                selecterCharacterCounter = 0;
                theHighestOccurringCharacter = String.valueOf(s.charAt(index));
            } else {
                selecterCharacterCounter = 0;
            }
        }
        return theHighestOccurringCharacter;
    }
}
