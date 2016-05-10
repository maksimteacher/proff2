package controller;

import domain.Answer;
import domain.Question;
import domain.User;
import service.AnswerServiceAbstract;
import service.QuestionServiceAbstract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
    private final String ANSWER_TOO_SHORT = "The answer should be at least 10 characters";
    private final String ANSWER_CREATED = "The answer was published";
    private QuestionServiceAbstract questionService = new QuestionServiceAbstract(Question.class);
    private AnswerServiceAbstract answerService = new AnswerServiceAbstract(Answer.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("answer") != null) {
            answerQuestion(req, resp);
        } else if (req.getParameter("submitAnswer") != null) {
            createNewAnswer(req, resp);
        } else {
            req.getSession().setAttribute("questionsTable", createQuestionsTable());
            req.getRequestDispatcher("jsp/employee.jsp").forward(req, resp);
        }
    }

    private void createNewAnswer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("newAnswerText");
        if (answer.length() > 10) {
            Answer newAnswer = new Answer();
            newAnswer.setAnswerContent(answer);
            User user = (User)req.getSession().getAttribute("user");
            newAnswer.setAnsweredBy(user);
            Question question = (Question) req.getSession().getAttribute("question");
            newAnswer.setQuestion(question);
            question.setStatus("answered");
            answerService.add(newAnswer);
            questionService.update(question);
            req.getSession().setAttribute("message", ANSWER_CREATED);
            req.getSession().setAttribute("questionsTable", createQuestionsTable());
            req.getRequestDispatcher("jsp/employee.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("message", ANSWER_TOO_SHORT);
            req.getRequestDispatcher("jsp/answerQuestion.jsp").forward(req, resp);
        }
    }

    private void answerQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionId = Integer.parseInt(req.getParameter("answer"));
        Question question = (Question) questionService.get(questionId);
        req.getSession().setAttribute("question", question);
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
