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
}
