package com.example.employee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Map the Servlet to "/employee"
@WebServlet("/employee")
public class employeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET requests - Displays Employee Management options
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Employee Management System</h1>");
        response.getWriter().println("<p><a href='/EmployeeManagement/addEmployee'>Add Employee</a></p>");
    }

    // Handles POST requests - Adds a new employee
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String position = request.getParameter("position");

        // Placeholder for database interaction (use JDBC to save data)
        response.setContentType("text/html");
        response.getWriter().println("<h1>Employee Added</h1>");
        response.getWriter().println("<p>Name: " + name + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("<p>Position: " + position + "</p>");
        response.getWriter().println("<p><a href='/EmployeeManagement/employee'>Go Back</a></p>");
    }
}

