package chapter_5;

import java.util.ArrayList;
import java.util.List;

public class GlobalWarmingQuiz {
    List<Questions> questions ;

    public GlobalWarmingQuiz() {
        QuestionsCreator.populate(questions);
    }

//    public GlobalWarmingQuiz(Questions questions) {
//        this.questions = new ArrayList<Questions>();
//    }
    public String getQuestion(int one) {
        return """
                Global warming is know as climate change.
                1. True.
                2. False.
                """;
    }
}
