package com.example.lab1;

import java.sql.*;

public class Lab1Application {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/cse456";
            String user = "root";
            String password = "123456";

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully");

            // Thực hiện truy vấn
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = pstmt.executeQuery();

            // Hiển thị dữ liệu
            System.out.printf("%-10s %-15s %-15s %-5s %-5s\n", "ID", "First Name", "Last Name", "YOB", "GPA");
            while (rs.next()) {
                System.out.printf("%-10s %-15s %-15s %-5s %-5s\n",
                        rs.getString("id"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("YOB"),
                        rs.getString("GPA"));
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
