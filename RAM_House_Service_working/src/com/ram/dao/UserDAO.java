package com.ram.dao;

import com.ram.dto.*;
import java.sql.*;

public class UserDAO
{
    public static User register(final User user) {
        Connection con = null;
        PreparedStatement ps = null;
        if (search(user.getEmailId())) {
            return null;
        }
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("insert into user(name,password,email,register_date,mobile_number,role) values(?,?,?,?,?,'user')", 1);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmailId());
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.setLong(5, user.getMobileNumber());
            if (ps.executeUpdate() > 0) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
                return user;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return null;
    }
    
    private static boolean search(final String email) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from user where email = ?");
            ps.setString(1, email);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return false;
    }
    
    public static User login(final String email, final String password) {
        Connection con = null;
        PreparedStatement ps = null;
        System.out.print(String.valueOf(email) + "        " + password);
        User user = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from user where email = ? and password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmailId(rs.getString("email"));
                user.setMobileNumber(rs.getLong("mobile_number"));
                user.setRegistrationDate(rs.getDate("register_date"));
                return user;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return user;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return user;
    }
    
    public static User loginAdmin(final String email, final String password) {
        Connection con = null;
        PreparedStatement ps = null;
        User user = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from user where role='admin' and email = ? and password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmailId(rs.getString("email"));
                user.setMobileNumber(rs.getLong("mobile_number"));
                user.setRegistrationDate(rs.getDate("register_date"));
                return user;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return user;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return user;
    }
    
    public User get(final int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from user where id = ?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmailId(rs.getString("email"));
                user.setMobileNumber(rs.getLong("mobile_number"));
                user.setRegistrationDate(rs.getDate("register_date"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return user;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return user;
    }
    
    public User get(final String email) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from user where email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmailId(rs.getString("email"));
                user.setMobileNumber(rs.getLong("mobile_number"));
                user.setRegistrationDate(rs.getDate("register_date"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return user;
        }
        finally {
            if (con != null) {
                DBUtility.close(con);
            }
        }
        if (con != null) {
            DBUtility.close(con);
        }
        return user;
    }
    
    public boolean updateUserDetails(final String password, final long mobileNumber, final int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("update user set mobile_number = ? , password = ? where id = ?");
            ps.setLong(1, mobileNumber);
            ps.setString(2, password);
            ps.setInt(3, userId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return false;
    }
}