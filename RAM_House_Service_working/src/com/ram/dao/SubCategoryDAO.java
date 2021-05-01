package com.ram.dao;

import com.ram.dto.*;
import java.sql.*;
import java.util.*;

public class SubCategoryDAO
{
    public static boolean add(final SubCategory subCategory) {
        Connection con = null;
        PreparedStatement ps = null;
        final String stmt = "insert into subcategory(type,category_id,image,deleted) values(?,?,?,0)";
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement(stmt);
            ps.setString(1, subCategory.getType());
            ps.setInt(2, subCategory.getCategoryId());
            ps.setString(3, String.valueOf(subCategory.getType()) + ".jpg");
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
    
    public static boolean delete(final int subCategoryId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("update subcategory set deleted = 1 where id = ? ");
            ps.setInt(1, subCategoryId);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static SubCategory get(final int subCategoryId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SubCategory subCategory = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from subcategory where deleted = 0 and id = ?");
            ps.setInt(1, subCategoryId);
            rs = ps.executeQuery();
            if (rs.next()) {
                subCategory = new SubCategory();
                subCategory.setId(rs.getInt("id"));
                subCategory.setType(rs.getString("type"));
                subCategory.setCategoryId(rs.getInt("category_id"));
                subCategory.setSubCategoryImage(rs.getString("image"));
                subCategory.setCategory(CategoryDAO.get(rs.getInt("category_id")));
                if (rs.getInt("deleted") != 0) {
                    subCategory.setDeleted(true);
                }
                else {
                    subCategory.setDeleted(false);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return subCategory;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return subCategory;
    }
    
    public static List<SubCategory> getSubCategories() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SubCategory> subCategoriesList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from subcategory where deleted = 0");
            rs = ps.executeQuery();
            subCategoriesList = new ArrayList<SubCategory>();
            while (rs.next()) {
                final SubCategory subCategory = new SubCategory();
                subCategory.setId(rs.getInt(1));
                subCategory.setType(rs.getString(2));
                subCategory.setCategoryId(rs.getInt(3));
                subCategory.setSubCategoryImage(rs.getString("image"));
                subCategory.setCategory(CategoryDAO.get(rs.getInt("category_id")));
                if (rs.getInt("deleted") != 0) {
                    subCategory.setDeleted(true);
                }
                else {
                    subCategory.setDeleted(false);
                }
                subCategoriesList.add(subCategory);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return subCategoriesList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return subCategoriesList;
    }
    
    public static List<SubCategory> getSubCategories(final int categoryId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SubCategory> subCategoriesList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from subcategory where deleted = 0 and category_id = ? ");
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            subCategoriesList = new ArrayList<SubCategory>();
            while (rs.next()) {
                final SubCategory subCategory = new SubCategory();
                subCategory.setId(rs.getInt(1));
                subCategory.setType(rs.getString(2));
                subCategory.setCategoryId(categoryId);
                subCategory.setSubCategoryImage(rs.getString("image"));
                if (rs.getInt("deleted") != 0) {
                    subCategory.setDeleted(true);
                }
                else {
                    subCategory.setDeleted(false);
                }
                subCategoriesList.add(subCategory);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return subCategoriesList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return subCategoriesList;
    }
}