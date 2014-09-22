package com.service;

import com.models.User;

import java.util.List;

/**
 * Created by Sunny on 4/4/14.
 */
public interface UserService {
    public Integer saveUser(User user);

    public User findUser(Integer userid);

    public List<User> findAllUsers();

    public Integer loginValidated(String userName, String passWord);

    public void updateUserInfo(Integer userId, String firstName, String lastName,
                               String address, String zipcode, String phone, String email);
    public void deleteUser(Integer userId);

    public void updateUserPassword(Integer userId, String password);

    public boolean containUserName(String username);

}
