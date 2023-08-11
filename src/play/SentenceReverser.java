package play;

public class SentenceReverser {
    public String reverseSentence(String givenInput) {
        String[] wordsInSentence = givenInput.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        boolean isNotA_validSentence = wordsInSentence.length < 2;
        if(isNotA_validSentence) throw new InputIsNotASentenceException("This is not a sentence");
        for(int index = wordsInSentence.length - 1; index >= 0; index--){
            reversedSentence.append(wordsInSentence[index]).append(" ");
        }
        return reversedSentence.toString().trim();
    }
}
