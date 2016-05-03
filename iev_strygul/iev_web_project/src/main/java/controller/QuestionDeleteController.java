package controller;

import domain.Question;
import service.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/questionDelete")
public class QuestionDeleteController extends HttpServlet {
    private QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionID = Integer.parseInt(req.getParameter("questionId"));
        List<Question> questions = (List<Question>)req.getSession().getAttribute("questionsList");
        Question question = null;
        for(Question q : questions) {
            if(q.getId().equals(questionID)) {
                question = q;
            }
        }
        questionService.delete(question);
        req.getRequestDispatcher("/user").forward(req, resp);
    }
}
