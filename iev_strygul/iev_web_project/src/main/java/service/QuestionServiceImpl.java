package service;

import domain.Question;

import java.util.ArrayList;

public class QuestionServiceImpl extends ServiceImpl {

    public QuestionServiceImpl(Class type) {
        super(type);
    }

    public ArrayList<Question> findAllQuestionsByUserLogin(String login) {
        return (ArrayList<Question>) dao.findByRestrictionEq("user_id", login);
    }
}
