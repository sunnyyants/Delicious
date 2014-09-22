package com.service.impl;

import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.models.User;
import com.service.UserService;

import java.util.List;

/**
 * Created by Sunny on 4/4/14.
 */
public class UserServiceImpl implements UserService{

    @Override
    public Integer saveUser(User user) {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.saveUser(user);
    }

    @Override
    public User findUser(Integer userid) {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.findUser(userid);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        UserDAO userDAO = new UserDAOImpl();
        List<User> list = userDAO.findAllUsers();
        return list;
    }

    @Override
    public Integer loginValidated(String userName, String passWord) {
        UserDAO userDAO = new UserDAOImpl();
        Integer isValided = userDAO.loginValidated(userName,passWord);
        return isValided;
    }

    @Override
    public void updateUserInfo(Integer userId, String firstName,
                               String lastName, String address, String zipcode, String phone, String email) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.updateUserInfo(userId,firstName,lastName,address,zipcode,phone,email);
    }

    @Override
    public void deleteUser(Integer userId) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.deleteUser(userId);
    }

    @Override
    public void updateUserPassword(Integer userId, String password) {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.updateUserPassword(userId, password);
    }

    @Override
    public boolean containUserName(String username) {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO.containUserName(username);
    }
}
