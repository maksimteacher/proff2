package controller;

import domain.Role;
import domain.User;
import service.RoleServiceImpl;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.NoSuchElementException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    public final String LOGIN_OCCUPIED_ERROR = "Login is occupied. Please, try another login.";
    public final  String REGISTRATION_ERROR = "Some problem occurred. Please, try to register again.";
    private RoleServiceImpl roleService = new RoleServiceImpl(Role.class);
    private UserServiceImpl userService = new UserServiceImpl(User.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getParameter("loginReg");
        String pass = req.getParameter("passReg");
        if (isLoginOccupied(login)) {
            req.setAttribute("loginError", LOGIN_OCCUPIED_ERROR);
            req.getRequestDispatcher("jsp/main.jsp").forward(req, res);
        } else {
            User user = createUser(login, pass);
            if(user != null) {
                redirectToCabinet(user, req, res);
            } else {
                req.setAttribute("loginError", REGISTRATION_ERROR);
                req.getRequestDispatcher("/main").forward(req, res);
            }
        }
    }

    private void redirectToCabinet(User user, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        userService.add(user);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        req.getRequestDispatcher("/user").forward(req, res);
    }

    private User createUser(String login, String pass) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);
        Role roleUser = roleService.findRole("user");
        if(roleUser != null) {
            user.setRole(roleUser);
        } else {
            throw new NoSuchElementException("Such role doesn't exist!");
        }
        return user;
    }

    private boolean isLoginOccupied(String login) {
             User user = new UserServiceImpl(User.class).findByLogin(login);
        if(user == null) return false;
        else return true;
    }
}
