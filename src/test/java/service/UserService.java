package service;

import com.example.employee.dao.UserDao;
import com.example.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    // Register user
    public boolean registerUser(User user) throws Exception {
        // Add any validation logic here
        return userDao.saveUser(user); // Call the DAO method
    }

    // Get user profile by email
    public User getUserProfile(String email) throws Exception {
        return userDao.getUserByEmail(email); // Call the DAO method
    }

    // Get all users
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers(); // Call the DAO method
    }
}
