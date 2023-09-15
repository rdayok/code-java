package chapter_5;

import chapter_5.GlobalWarmingQuiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GlobalWarmingQuizTest {
    GlobalWarmingQuiz quiz = new GlobalWarmingQuiz();

    @Test
    public void testQuizServeTheQuestionOneSpecified() {
        String expectedQuestionWithOptions = """
                Global warming is known as climate change.
                Press 1 for true.
                Press 2 for false.
                """;
        int one = 1;
        assertEquals(expectedQuestionWithOptions, quiz.getQuestion(one));
    }
    @Test
    public void testQuizServeTheQuestionTwoSpecified() {
        String expectedQuestionWithOptions = """
                Is climate change referred to changes in Earth's climate at local, regional, or global scales?
                Press 1 for true.
                Press 2 for false.
                """;
        int two = 2;
        assertEquals(expectedQuestionWithOptions, quiz.getQuestion(two));
    }
    @Test
    public void testQuizServeQuestionThreeSpecified() {
        String expectedQuestionWithOptions = """
                Global warming makes our environment good to live in.
                Press 1 for true.
                Press 2 for false.
                """;
        int two = 3;
        assertEquals(expectedQuestionWithOptions, quiz.getQuestion(two));
    }

    @Test
    public void testFalseIsReturnedAsAnswerForQuestionThree() {
        boolean expectedAnswer = false;
        int three = 3;
        assertFalse(quiz.getAnswerForQuestion(three));
    }
}
