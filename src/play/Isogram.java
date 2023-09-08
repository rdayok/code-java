package play;

public class Isogram {
    public boolean checkIfAnIsogramFor(String userInput) {
        boolean charactersOfInputAreLessThanTwentySix = !isThereTwentySixCharactersFor(userInput);
        boolean thereAreCharactersOtherThanAlphabets = isThereACharacterOtherThanAlphabetsFor(userInput);
        if(charactersOfInputAreLessThanTwentySix || thereAreCharactersOtherThanAlphabets) return false;
        String capitalizedUserInput = userInput.toUpperCase();
        for (int index = 0; index < capitalizedUserInput.length(); index++) {
            for (int index2 = index + 1; index2 < capitalizedUserInput.length() ; index2++) {
                if(capitalizedUserInput.charAt(index) == capitalizedUserInput.charAt(index2)) return false;
            }
        }
        return true;
    }

    private Boolean isThereTwentySixCharactersFor(String userInput) {
        return (userInput.length() == 26);
    }

    private boolean isThereACharacterOtherThanAlphabetsFor(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            if (!Character.isLetter(userInput.charAt(index))) return true;
        }
        return false;
    }
}
