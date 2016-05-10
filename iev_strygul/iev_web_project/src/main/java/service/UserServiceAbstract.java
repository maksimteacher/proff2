package service;

import domain.User;

public class UserServiceAbstract extends ServiceAbstract {

    public UserServiceAbstract(Class type) {
        super(type);
    }

    public User findByLogin(String login) {
       return (User) dao.findByRestrictionEq("login", login);
    }
}
