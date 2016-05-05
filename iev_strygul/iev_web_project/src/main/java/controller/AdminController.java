package controller;

import domain.Question;
import domain.Theme;
import service.QuestionServiceImpl;
import service.ThemeServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminController extends HttpServlet{
    private ThemeServiceImpl themeService = new ThemeServiceImpl(Theme.class);
    private QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("review") != null) {
            showReviewPage(req, resp);
        } else if(req.getParameter("questionStatus") != null ) {
            reviewQuestion(req, resp);
        } else {
            showAdminCabinet(req, resp);
        }
    }

    private void showAdminCabinet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("questionsTable", createQuestionsTable());
        req.getRequestDispatcher("jsp/admin.jsp").forward(req, resp);
    }

    private void reviewQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        showAdminCabinet(req, resp);
    }

    private void showReviewPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionId = Integer.parseInt(req.getParameter("review"));
        Question question = (Question) questionService.get(questionId);
        req.getSession().setAttribute("questionTitle", question.getTitle());
        req.getSession().setAttribute("questionContent", question.getQuestion());
        req.getSession().setAttribute("questionEdit", question);
        req.getSession().setAttribute("droplist", createDropList());
        req.getRequestDispatcher("jsp/reviewQuestion.jsp").forward(req, resp);
    }

    private String createDropList() {
        ArrayList<Theme> themes = (ArrayList<Theme>)themeService.getAll();
        StringBuilder sb = new StringBuilder("<select name=\"theme\" required>");
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

    private String createQuestionsTable() {
        ArrayList<Question> questions = (ArrayList<Question>)questionService.findAllQuestionsForReview();
        if(questions != null) {
            StringBuilder sb = new StringBuilder("<br><br><br><table> <th align=\"center\"> All Questions That Need Your Review </th>");
            for(int i = 0; i < questions.size(); i++) {
                sb.append("<tr><td>");
                sb.append(questions.get(i).getTitle());
                sb.append("</td>");
                sb.append("<td>");
                sb.append("<form action = \"/admin\" method=\"post\"><button type=\"submit\" name=\"review\" value=\"");
                sb.append(questions.get(i).getId());
                sb.append("\">Review</button></form>");
                sb.append("</td></tr>");
            }
            sb.append("</table>");
            return sb.toString();
        } else {
            String s = "";
            return s;
        }
    }
}
