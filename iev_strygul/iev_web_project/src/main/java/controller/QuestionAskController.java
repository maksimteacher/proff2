package controller;

import domain.Question;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questionAsk")
public class QuestionAskController extends HttpServlet {
    public final String QUESTION_CREATED_MESSAGE = "Your question was successfully created.";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titleOfNewQuestion = (String) req.getParameter("newQuestionTitle");
        String textOfNewQuestion = (String) req.getParameter("newQuestionText");
        User user = (User) req.getSession().getAttribute("user");
        Question newQuestionInstance = new Question();
        newQuestionInstance.setQuestion(textOfNewQuestion);
        newQuestionInstance.setAskedByUser(user);
        newQuestionInstance.setStatus("not answered");
        newQuestionInstance.setTitle(titleOfNewQuestion);
        req.getSession().setAttribute("message", QUESTION_CREATED_MESSAGE);
        req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
    }
}
