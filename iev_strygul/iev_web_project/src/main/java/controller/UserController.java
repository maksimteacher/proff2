package controller;

import domain.Question;
import domain.User;
import service.QuestionServiceAbstract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {
    public final String QUESTION_CREATED_MESSAGE = "Your question was successfully created.";
    public final String QUESTION_TITLE_TOO_SHORT = "The title of your question doesn't exceed 5 characters.";
    public final String QUESTION_TOO_SHORT = "Your question is too short.";
    public final String QUESTION_DELETED = "The question was deleted.";
    public final String QUESTION_EDITED = "Your question was edited.";
    private QuestionServiceAbstract questionService = new QuestionServiceAbstract(Question.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("submit") != null) {
            submitNewQuestion(req, resp);
        } else if (req.getParameter("edit") != null) {
            editQuestion(req, resp);
        } else if (req.getParameter("delete") != null) {
            deleteQuestion(req, resp);
        } else if (req.getParameter("update") != null) {
            updateQuestion(req, resp);
        } else {
            showUserCabinet(req, resp);
        }
    }

    private void createQuestionsTable(String login, HttpServletRequest req) {
        List<Question> questions = questionService.findAllQuestionsByUserLogin(login);
        req.getSession().setAttribute("questionsList", questions);
        if(questions != null) {
            StringBuilder sb = new StringBuilder("<br><br><br><table> <h1> All Questions Asked by User </h1>");
            for(int i = 0; i < questions.size(); i++) {
                sb.append("<tr><td>");
                sb.append(questions.get(i).getTitle());
                sb.append(". <b>Status:</b> ");
                sb.append(questions.get(i).getStatus().getStatus());
                sb.append("</td>");
                sb.append("<td>");
                sb.append("<button type=\"submit\" name=\"edit\" value=\"");
                sb.append(questions.get(i).getId());
                sb.append("\">Edit</button>");
                sb.append("</td>");
                sb.append("<td>");
                sb.append("<button type=\"submit\" name=\"delete\" value="
                        + questions.get(i).getId() + ">Delete question</button>");
                sb.append("</td></tr>");
            }
            sb.append("</table>");
            String questionsTable = sb.toString();
            req.getSession().setAttribute("questionsTable", questionsTable);
        }
    }

    private void deleteQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionID = Integer.parseInt(req.getParameter("delete"));
        List<Question> questions = (List<Question>)req.getSession().getAttribute("questionsList");
        Question question = null;
        for(Question q : questions) {
            if(q.getId().equals(questionID)) {
                question = q;
            }
        }
        questionService.delete(question);
        req.getSession().setAttribute("message", QUESTION_DELETED);
        showUserCabinet(req, resp);
    }

    private void editQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer questionId = Integer.parseInt(req.getParameter("edit"));
        Question question = (Question) questionService.get(questionId);
        req.getSession().setAttribute("questionTitle", question.getTitle());
        req.getSession().setAttribute("questionContent", question.getQuestion());
        req.getSession().setAttribute("questionEdit", question);
        req.getRequestDispatcher("jsp/editQuestion.jsp").forward(req, resp);
    }

    private void showUserCabinet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        createQuestionsTable(user.getLogin(), req);
        req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
    }

    private void submitNewQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titleOfNewQuestion = (String) req.getParameter("newQuestionTitle");
        String textOfNewQuestion = (String) req.getParameter("newQuestionText");
        if(titleOfNewQuestion.length() < 5) {
            req.getSession().setAttribute("message", QUESTION_TITLE_TOO_SHORT);
            req.getRequestDispatcher("/user").forward(req, resp);
        } else if(textOfNewQuestion.length() < 10) {
            req.getSession().setAttribute("message", QUESTION_TOO_SHORT);
            req.getRequestDispatcher("/user").forward(req, resp);
        } else {
            Question newQuestionInstance = new Question();
            newQuestionInstance.setQuestion(textOfNewQuestion);
            newQuestionInstance.setAskedByUser((User)req.getSession().getAttribute("user"));
            newQuestionInstance.setStatus("needs approval");
            newQuestionInstance.setTitle(titleOfNewQuestion);
            questionService.add(newQuestionInstance);
            req.getSession().setAttribute("message", QUESTION_CREATED_MESSAGE);
            showUserCabinet(req, resp);
        }
    }

    private void updateQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String questionTitle = req.getParameter("questionTitle");
        String questionContent = req.getParameter("questionContent");
        Question question = (Question) req.getSession().getAttribute("questionEdit");
        question.setTitle(questionTitle);
        question.setQuestion(questionContent);
        questionService.update(question);
        req.getSession().setAttribute("message", QUESTION_EDITED);
        showUserCabinet(req, resp);
    }
}