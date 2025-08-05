package com.tns.fooddeliverysystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/food_delivery";
    private static final String USER = "root";
    private static final String PASSWORD = "sam123"; // 🔑 Change this!

    // Get database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Close resources (overloaded methods)
    public static void closeResources(Connection conn) {
        closeResources(conn, null, null);
    }

    public static void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }

    public static void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing database resources: " + e.getMessage());
        }
    }
}
