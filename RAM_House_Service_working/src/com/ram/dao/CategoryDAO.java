package com.ram.dao;

import com.ram.dto.*;
import java.sql.*;
import java.util.*;

public class CategoryDAO
{
    public static boolean add(final Category category) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("insert into category(type,image,deleted) values(?,?,0)");
            ps.setString(1, category.getType());
            ps.setString(2, String.valueOf(category.getType()) + ".jpg");
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
    
    public static boolean delete(final int categoryId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("update category set deleted=1 where id = ?");
            ps.setInt(1, categoryId);
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
    
    public static Category get(final int categoryId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Category category = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from category where deleted =0 and id = ?");
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setType(rs.getString("type"));
                category.setCategoryImage(rs.getString("image"));
                if (rs.getInt("deleted") != 0) {
                    category.setDeleted(true);
                }
                else {
                    category.setDeleted(false);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return category;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return category;
    }
    
    public static List<Category> getCategories() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Category> categoriesList = null;
        try {
            con = DBUtility.getConnection();
            if (con == null) {
            	System.out.println("con is null");
            }
            ps = con.prepareStatement("select * from category where deleted = 0");
            rs = ps.executeQuery();
            categoriesList = new ArrayList<Category>();
            while (rs.next()) {
                final Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setType(rs.getString("type"));
                category.setCategoryImage(rs.getString("image"));
                if (rs.getInt("deleted") != 0) {
                    category.setDeleted(true);
                }
                else {
                    category.setDeleted(false);
                }
                categoriesList.add(category);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return categoriesList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return categoriesList;
    }
}