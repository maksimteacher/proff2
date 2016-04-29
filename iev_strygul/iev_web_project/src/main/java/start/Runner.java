package start;

import dao.GenericDaoImpl;
import domain.User;
import service.UserServiceImpl;

import java.util.List;

/**
 * Created by Notebook on 27.04.2016.
 */
public class Runner {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl(User.class);
        User user = userService.findByLogin("admin");
        System.out.println(user);
    }
}

