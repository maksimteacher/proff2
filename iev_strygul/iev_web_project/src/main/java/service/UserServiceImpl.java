package service;

import domain.User;

import java.util.List;

/**
 * Created by Notebook on 28.04.2016.
 */
public class UserServiceImpl extends ServiceImpl {

    public UserServiceImpl(Class type) {
        super(type);
    }

    public User findByLogin(String login) {
       return (User) dao.findAllByRestrictionEq("login", login);
    }
}
