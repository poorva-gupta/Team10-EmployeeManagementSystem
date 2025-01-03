package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // Database URL, Username, and Password (replace with your own)
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";  // Database URL
    private static final String USER = "root";  // Database Username
    private static final String PASSWORD = "yourpassword";  // Database Password

    // Method to get a connection to the database
    public static Connection getConnection() throws SQLException {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Return a new connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }
}

