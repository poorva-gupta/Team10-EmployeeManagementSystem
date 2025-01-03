package com.example.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.example.model.User;

public class UserDao {
    private static Connection connection;
    
        public UserDao(Connection connection) {
            this.connection = connection;
        }
    
        public UserDao() {
            //TODO Auto-generated constructor stub
        }
    
        public static boolean saveUser(User user) throws Exception {
            String sql = "INSERT INTO users (name, email, position) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPosition());
            return stmt.executeUpdate() > 0;
        }
    }

    public User getUserByEmail(String email) throws Exception {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("position"));
            }
            return null;
        }
    }

    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }
}
