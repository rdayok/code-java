package play;

public class Isogram {
    public boolean checkIfAnIsogramFor(String userInput) {
        String alphabetsFromUserInput = getAlphabetsFrom(userInput);
        if (isLengthNotTwentySixFor(alphabetsFromUserInput)) return false;
        String capitalizedUserInput = alphabetsFromUserInput.toUpperCase();
        for (int index = 0; index < capitalizedUserInput.length(); index++) {
            for (int index2 = index + 1; index2 < capitalizedUserInput.length() ; index2++) {
                if(capitalizedUserInput.charAt(index) == capitalizedUserInput.charAt(index2)) return false;
            }
        }
        return true;
    }

    private boolean isLengthNotTwentySixFor(String userInput) {
        return (!(userInput.length() == 26));
    }

    private String getAlphabetsFrom(String userInput) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < userInput.length(); index++) {
            if(Character.isLetter(userInput.charAt(index))) builder.append(userInput.charAt(index));
        }
        return builder.toString();
    }
}
