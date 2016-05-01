package start;

import domain.Question;
import service.QuestionServiceImpl;

public class Runner {
    public static void main(String[] args) {
        QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);
        questionService.findAllQuestionsByUserLogin("user");

    }
}

