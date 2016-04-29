package service;

import domain.User;

public class UserServiceImpl extends ServiceImpl {

    public UserServiceImpl(Class type) {
        super(type);
    }

    public User findByLogin(String login) {
       return (User) dao.findByRestrictionEq("login", login);
    }
}
