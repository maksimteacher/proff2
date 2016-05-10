package service;

import domain.Question;

import java.util.List;

public class QuestionServiceAbstract extends ServiceAbstract {

    public QuestionServiceAbstract(Class type) {
        super(type);
    }

    public List<Question> findAllQuestionsByUserLogin(String login) {
       return (List<Question>) dao.findAllByForObRestrictionEq("askedByUser", "login", login);
    }

    public List<Question> findAllQuestionsForReview() {
        return (List<Question>) dao.findAllByForObRestrictionEq("status", "status", "needs approval");
    }

    public List<Question> findAllQuestionsForAnswering() {
        return (List<Question>) dao.findAllByForObRestrictionEq("status", "status", "approved");
    }
}
