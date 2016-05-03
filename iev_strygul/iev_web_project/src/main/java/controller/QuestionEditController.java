package controller;

import domain.Question;
import service.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questionEdit")
public class QuestionEditController extends HttpServlet {
    QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("questionId"));
       Integer questionId = Integer.parseInt(req.getParameter("questionId"));
       Question question = (Question) questionService.get(questionId);
       req.getSession().setAttribute("questionTitle", question.getTitle());
        req.getSession().setAttribute("questionContent", question.getQuestion());
        req.getSession().setAttribute("questionEdit", question);
        req.getRequestDispatcher("jsp/editQuestion.jsp").forward(req, resp);
    }
}
