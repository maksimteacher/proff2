package controller;

import domain.User;
import service.UserServiceAbstract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/main")
public class MainController extends HttpServlet {
    public final String LOGIN_ERROR = "Incorrect username or password. Please, try again.";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCookie(req);
        String name = (String) req.getParameter("loginIn");
        String pass = (String) req.getParameter("passIn");
        User user = authorize(name, pass);
        if(user != null) {
            createCookie(resp, name);
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            session.setAttribute("user", user);
            String role = user.getRole().getRole();
            switch(role) {
                case "user": req.getRequestDispatcher("/user").forward(req, resp);
                    break;
                case "employee": req.getRequestDispatcher("/employee").forward(req, resp);
                    break;
                case "admin": req.getRequestDispatcher("/admin").forward(req, resp);
                    break;
            }
        } else {
            req.setAttribute("loginError", LOGIN_ERROR);
            req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCookie(req);
        resp.sendRedirect("jsp/main.jsp");
    }

    private User authorize(String login, String pass) {
        User user = findUser(login);
        if(user != null) {
            if(user.getPassword().equals(pass)) {
                return user;
            }
        }
        return null;
    }

    private User findUser(String login) {
       return new UserServiceAbstract(User.class).findByLogin(login);
    }

    private void createCookie(HttpServletResponse resp, String name) throws IOException {
        Cookie cookie = new Cookie("cook", name);
        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        resp.addCookie(cookie);
    }

    private void getCookie(HttpServletRequest req) {
        Cookie[] arrCook = req.getCookies();
        if(arrCook != null) {
            for (Cookie cook : arrCook) {
                if (cook.getName().equals("cook")) {
                    req.setAttribute("name", cook.getValue());
                }
            }
        }
    }
}



