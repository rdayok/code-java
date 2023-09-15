package chapter_5;

public class GlobalWarmingQuiz {

    private Questionnaire questionair;

    public GlobalWarmingQuiz(){
        questionair = new Questionnaire();
    }

    public String getQuestion(int questionNumber) {
        return questionair.getQuestion(questionNumber);
    }

    public boolean getAnswerForQuestion(int questionNumber) {
        return questionair.getAnswerForQuestion(questionNumber);
    }
}
