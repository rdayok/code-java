package play;

public class Isogram {
    public boolean checkIfAnIsogramFor(String userInput) {
        String userInputWithOutSpace = removeSpaceFor(userInput);
        if (isValidFor(userInputWithOutSpace)) return false;
        String capitalizedUserInput = userInputWithOutSpace.toUpperCase();
        for (int index = 0; index < capitalizedUserInput.length(); index++) {
            for (int index2 = index + 1; index2 < capitalizedUserInput.length() ; index2++) {
                if(capitalizedUserInput.charAt(index) == capitalizedUserInput.charAt(index2)) return false;
            }
        }
        return true;
    }

    private boolean isValidFor(String userInputWithOutSpace) {
        boolean charactersOfInputAreLessThanTwentySix = !isThereTwentySixCharactersFor(userInputWithOutSpace);
        boolean thereAreCharactersOtherThanAlphabets = isThereACharacterOtherThanAlphabetsFor(userInputWithOutSpace);
        return charactersOfInputAreLessThanTwentySix || thereAreCharactersOtherThanAlphabets;
    }

    private String removeSpaceFor(String userInput) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < userInput.length(); index++) {
            if (userInput.charAt(index) != ' ') builder.append(userInput.charAt(index));
        }
        return builder.toString();
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
