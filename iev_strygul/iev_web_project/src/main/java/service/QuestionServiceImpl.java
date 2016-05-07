package service;

import domain.Question;

import java.util.List;

public class QuestionServiceImpl extends ServiceImpl {

    public QuestionServiceImpl(Class type) {
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
