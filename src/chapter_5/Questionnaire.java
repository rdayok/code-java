package chapter_5;

import java.util.ArrayList;
import java.util.List;

public class Questionnaire {
    private List<Question> questions = new ArrayList<>() ;

    public Questionnaire() {
        setQuestions();
    }

    public String getQuestion(int givenQuestionNumber) {
        Question question = questions.get(--givenQuestionNumber );
        return question.toString();
    }
    public boolean getAnswerForQuestion(int givenQuestionNumber) {
        return questions.get(--givenQuestionNumber).getAnswer();
    }

    private void setQuestions() {
        setQuestionOne();
        setQuestionTwo();
        setQuestionThree();
        setQuestionFour();
        setQuestionFive();
    }

    private void setQuestionOne() {
        String question = "Global warming is known as climate change.";
        String optionOne = "Press 1 for true.";
        String optionTwo = "Press 2 for false.";
        addQuestionToList(question, optionOne, optionTwo, true);
    }

    private void setQuestionTwo() {
        String question = "Is climate change referred to changes in Earth's climate at local, regional, or global scales?";
        String optionOne = "Press 1 for true.";
        String optionTwo = "Press 2 for false.";
        addQuestionToList(question, optionOne, optionTwo, true);
    }

    private void setQuestionThree() {
        String question = "Global warming makes our environment good to live in.";
        String optionOne = "Press 1 for true.";
        String optionTwo = "Press 2 for false.";
        addQuestionToList(question, optionOne, optionTwo, false);
    }

    private void setQuestionFour() {
        String question = "Does the burning of fossil fuels and removal of forests causes climate chang?";
        String optionOne = "Press 1 for true.";
        String optionTwo = "Press 2 for false.";
        addQuestionToList(question, optionOne, optionTwo, true);
    }

    private void setQuestionFive() {
        String question = "The human influence has been the dominant cause of observed warming trends since the 20th century.";
        String optionOne = "Press 1 for true.";
        String optionTwo = "Press 2 for false.";
        addQuestionToList(question, optionOne, optionTwo, true);
    }

    private void addQuestionToList(String specifiedQuestion, String optionOne, String optionTwo, boolean answer) {
        Question question = new Question();
        question.setQuestion(specifiedQuestion);
        question.setOptionOne(optionOne);
        question.setOptionTwo(optionTwo);
        question.setAnswer(answer);
        questions.add(question);
    }
}
