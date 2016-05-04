package controller;

import domain.Question;
import service.QuestionServiceImpl;

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

    private QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("questionsTable", createQuestionsTable());
        req.getRequestDispatcher("jsp/admin.jsp").forward(req, resp);
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
                sb.append("<form action = \"/review\" method=\"post\"><button type=\"submit\" name=\"questionId\" value=\"");
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
