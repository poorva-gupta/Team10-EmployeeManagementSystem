package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;

public class UserDao {

    private static final Statement DatabaseUtil = null;
    
        // Method to save a user in the database
        public boolean saveUser(User user) throws SQLException {
            String query = "INSERT INTO users (name, email, position) VALUES (?, ?, ?)";
            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(query)) {
    
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPosition());
    
                return stmt.executeUpdate() > 0;  // Returns true if user is successfully inserted
            }
        }
    
        // Method to fetch a user by email
        public User getUserByEmail(String email) throws SQLException {
            String query = "SELECT * FROM users WHERE email = ?";
            try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                return new com.example.model.User(id, name, email, position);
            }

            return null;  // Return null if no user found
        }
    }

    // Method to fetch all users
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String position = rs.getString("position");
                users.add(new User(id, name, email, position));
            }
        }

        return users;
    }
}
