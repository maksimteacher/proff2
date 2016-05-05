package controller;

import domain.Question;
import domain.Theme;
import service.QuestionServiceImpl;
import service.ThemeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questionReviewPage")
public class QuestionReviewPageController extends HttpServlet {
    QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);
    ThemeServiceImpl themeService = new ThemeServiceImpl(Theme.class);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionStatus = req.getParameter("questionStatus");
        Question question = (Question) req.getSession().getAttribute("questionEdit");
        if(questionStatus.equals("approved")) {
            String questionTitle = req.getParameter("questionTitle");
            String questionContent = req.getParameter("questionContent");
            if(questionTitle.equals(question.getTitle()) || questionContent.equals(question.getQuestion())) {
                question.setTitle(questionTitle);
                question.setQuestion(questionContent);
            }
            String questionTheme = req.getParameter("theme");
            Theme questionThemeInstance = themeService.findTheme(questionTheme);
            if(questionThemeInstance != null) {
                question.setTheme(questionThemeInstance);
            } else {
                Theme newTheme = new Theme();
                newTheme.setTheme(questionTheme);
                question.setTheme(newTheme);
            }
            question.setStatus("approved");
        } else {
            question.setStatus("disapproved");
        }
        questionService.update(question);
        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
