package controller;

import domain.Question;
import domain.Theme;
import service.QuestionServiceImpl;
import service.ServiceImpl;
import service.ThemeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/review")
public class QuestionReviewController extends HttpServlet {
    private ServiceImpl questionService = new QuestionServiceImpl(Question.class);
    private ThemeServiceImpl themeService = new ThemeServiceImpl(Theme.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionId = Integer.parseInt(req.getParameter("questionId"));
        Question question = (Question) questionService.get(questionId);
        req.getSession().setAttribute("questionTitle", question.getTitle());
        req.getSession().setAttribute("questionContent", question.getQuestion());
        req.getSession().setAttribute("questionEdit", question);
        req.getSession().setAttribute("droplist", createDropList());
    }

    private String createDropList() {
        ArrayList<Theme> themes = (ArrayList<Theme>)themeService.getAll();
        StringBuilder sb = new StringBuilder("<select name=\"theme\">");
        for(Theme th : themes) {
            String themeName = th.getTheme();
            Integer themeId = th.getId();
            sb.append("<option value=\"");
            sb.append(themeId);
            sb.append("\">");
            sb.append(themeName);
            sb.append("</option>");
        }
        return sb.toString();
    }
}
