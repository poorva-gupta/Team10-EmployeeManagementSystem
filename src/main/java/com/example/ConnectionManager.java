package com.example.employeemanagement;

import java.sql.*;

public class ConnectionManager {
    Connection connection;
    Statement statement;

    public ConnectionManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeemanagement", "root", "ZXdf@#24");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
