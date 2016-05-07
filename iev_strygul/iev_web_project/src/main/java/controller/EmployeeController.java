package controller;

import domain.Question;
import service.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
    private QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("answer") != null) {
            answerQuestion(req, resp);
        } else {
            req.getSession().setAttribute("questionsTable", createQuestionsTable());
            req.getRequestDispatcher("jsp/employee.jsp").forward(req, resp);
        }
    }

    private void answerQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionId = Integer.parseInt(req.getParameter("answer"));
        Question question = (Question) questionService.get(questionId);
        req.getSession().setAttribute("questionTitle", question.getTitle());
        req.getSession().setAttribute("questionTheme", question.getTheme().getTheme());
        req.getSession().setAttribute("questionAskedBy", question.getAskedByUser().getLogin());
        req.getSession().setAttribute("questionContent", question.getQuestion());
        req.getRequestDispatcher("jsp/answerQuestion.jsp").forward(req, resp);
    }

    private String createQuestionsTable() {
        ArrayList<Question> questions = (ArrayList<Question>)questionService.findAllQuestionsForAnswering();
        if(questions != null) {
            StringBuilder sb = new StringBuilder("<br><br><br><table> <th align=\"center\"> All Questions That Need Your Answers </th>");
            for(int i = 0; i < questions.size(); i++) {
                sb.append("<tr><td>");
                sb.append(questions.get(i).getTitle());
                sb.append("</td>");
                sb.append("<td>");
                sb.append("<form action = \"/employee\" method=\"post\"><button type=\"submit\" name=\"answer\" value=\"");
                sb.append(questions.get(i).getId());
                sb.append("\">Answer</button></form>");
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
