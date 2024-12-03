package com.example.employee.servlet;

import com.example.employee.util.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String salary = request.getParameter("salary");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE Employee SET name=?, email=?, department=?, salary=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, department);
            stmt.setString(4, salary);
            stmt.setInt(5, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("listEmployees.html");
    }
}
