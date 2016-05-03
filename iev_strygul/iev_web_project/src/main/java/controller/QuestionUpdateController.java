package controller;

import domain.Question;
import service.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questionUpdate")
public class QuestionUpdateController extends HttpServlet {
    private QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);
    public final String QUESTION_EDITED = "Your question was edited.";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionTitle = req.getParameter("questionTitle");
        String questionContent = req.getParameter("questionContent");
       Question question = (Question) req.getSession().getAttribute("questionEdit");
        System.out.println(questionTitle + " " + questionContent);
        question.setTitle(questionTitle);
        question.setQuestion(questionContent);
        questionService.update(question);
        req.getSession().setAttribute("message", QUESTION_EDITED);
        req.getRequestDispatcher("/user").forward(req, resp);
    }
}
