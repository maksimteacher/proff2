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

@WebServlet("/questionAsk")
public class QuestionAskController extends HttpServlet {
    public final String QUESTION_CREATED_MESSAGE = "Your question was successfully created.";
    public final String QUESTION_TITLE_TOO_SHORT = "The title of your question doesn't exceed 5 characters.";
    public final String QUESTION_TOO_SHORT = "Your question is too short.";
    private QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titleOfNewQuestion = (String) req.getParameter("newQuestionTitle");
        String textOfNewQuestion = (String) req.getParameter("newQuestionText");
        if(titleOfNewQuestion.length() < 5) {
            req.getSession().setAttribute("message", QUESTION_TITLE_TOO_SHORT);
            req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
        } else if(textOfNewQuestion.length() < 10) {
            req.getSession().setAttribute("message", QUESTION_TOO_SHORT);
            req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
        } else {
            Question newQuestionInstance = new Question();
            newQuestionInstance.setQuestion(textOfNewQuestion);
            newQuestionInstance.setAskedByUser((User)req.getSession().getAttribute("user"));
            newQuestionInstance.setStatus("not answered");
            newQuestionInstance.setTitle(titleOfNewQuestion);
            questionService.add(newQuestionInstance);
            req.getSession().setAttribute("message", QUESTION_CREATED_MESSAGE);
            req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
        }
    }
}