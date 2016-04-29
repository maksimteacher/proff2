package controller;

import domain.Question;
import domain.User;
import service.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/user")
public class UserController extends HttpServlet {
    QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<Question> questions = questionService.findAllQuestionsByUserLogin(user.getLogin());
    }
}
