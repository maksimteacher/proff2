package service;

import domain.User;

public class UserServiceImpl extends ServiceImpl {

    public UserServiceImpl(Class type) {
        super(type);
    }

    public User findByLogin(String login) {
       return (User) dao.findAllByRestrictionEq("login", login);
    }
}
