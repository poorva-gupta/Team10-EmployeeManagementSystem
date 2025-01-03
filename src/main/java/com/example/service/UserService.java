package com.example.service;

import com.example.employee.dao.UserDao;
import com.example.model.User;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean registerUser(User user) throws Exception {
        if (user.getEmail() == null || user.getName() == null || user.getPosition() == null) {
            throw new IllegalArgumentException("All fields are required");
        }
        return userDao.saveUser(user);
    }

    public User getUserProfile(String email) throws Exception {
        return userDao.getUserByEmail(email);
    }
}
