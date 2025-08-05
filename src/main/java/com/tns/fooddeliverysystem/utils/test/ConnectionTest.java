package com.tns.fooddeliverysystem.utils.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tns.fooddeliverysystem.utils.DBUtil;

public class ConnectionTest {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            System.out.println("✅ JDBC Connection successful!");

            // Optional: Test a simple SQL query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT 1+1 AS result");
            if (rs.next()) {
                System.out.println("Database test query result: " + rs.getInt("result"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection failed:");
            System.out.println(e.getMessage());
        } finally {
            DBUtil.closeResources(conn, null, null);
        }
    }
}
