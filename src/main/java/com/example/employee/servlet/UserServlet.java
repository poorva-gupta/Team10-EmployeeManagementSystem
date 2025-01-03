package com.example.employee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee_management";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "password";

    /**
     * Handles HTTP POST requests for user registration.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String position = request.getParameter("position");

        try {
            // Load JDBC driver and connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // Insert user data into the database
            String sql = "INSERT INTO users (name, email, position) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, position);

            statement.executeUpdate();
            conn.close();

            // Redirect to the user profile page
            response.sendRedirect("/EmployeeManagement/user");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error occurred: " + e.getMessage() + "</p>");
        }
    }

    /**
     * Handles HTTP GET requests to display user profile data.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Load JDBC driver and connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // Fetch the latest user data
            String sql = "SELECT * FROM users ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Forward user data to the JSP page
            if (resultSet.next()) {
                request.setAttribute("name", resultSet.getString("name"));
                request.setAttribute("email", resultSet.getString("email"));
                request.setAttribute("position", resultSet.getString("position"));
            } else {
                request.setAttribute("errorMessage", "No user profile found. Please register first.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error occurred: " + e.getMessage());
        }

        // Forward to the JSP page
        request.getRequestDispatcher("/jsp/userProfile.jsp").forward(request, response);
    }
}
