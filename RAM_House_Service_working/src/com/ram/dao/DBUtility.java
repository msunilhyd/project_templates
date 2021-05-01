package com.ram.dao;

import java.sql.*;

public class DBUtility
{
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RAM", "ramuser", "linus");
            return con;
        }
        catch (Exception ex) {
            System.out.println("Error -->" + ex.getMessage());
            return null;
        }
    }
    
    public static void close(final Connection con) {
        try {
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}