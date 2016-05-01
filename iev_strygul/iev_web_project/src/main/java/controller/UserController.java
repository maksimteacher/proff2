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
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {
    QuestionServiceImpl questionService = new QuestionServiceImpl(Question.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String questionsTable = createQuestionsTable(user.getLogin());
        req.getSession().setAttribute("questionsTable", questionsTable);
        req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
    }

    private String createQuestionsTable(String login) {
        List<Question> questions = questionService.findAllQuestionsByUserLogin(login);
        if(questions != null) {
            StringBuilder sb = new StringBuilder("<br><br><br><table> <tr> <th> All Questions Asked by User </th>");
            for(int i = 0; i < questions.size(); i++) {
                sb.append("<td>");
                sb.append(questions.get(i).getTitle());
                sb.append("</td>");
                sb.append("<td>");
                sb.append("<form action = &ldquo;/questionEdit&rdquo; name = &ldquo;questionId&rdquo;><button value = "
                        + questions.get(i).getId() + ">Edit question</button></form>");
                sb.append("</td>");
                sb.append("<td>");
                sb.append("<form action = &ldquo;/questionDelete&rdquo; name = &ldquo;questionId&rdquo;><button value = "
                        + questions.get(i).getId() + ">Delete question</button></form>");
                sb.append("</td>");
            }
            sb.append("</tr></table>");
            return sb.toString();
        } else {
            String s = "";
            return s;
        }
    }
}
