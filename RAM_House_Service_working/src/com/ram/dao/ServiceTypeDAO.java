package com.ram.dao;

import com.ram.dto.*;
import java.sql.*;
import java.util.*;

public class ServiceTypeDAO
{
    public static boolean add(final ServiceType serviceType) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            final String stmt = "insert into service(description,approx_price,subcategory_id,deleted) values(?,?,?,0)";
            con = DBUtility.getConnection();
            ps = con.prepareStatement(stmt);
            ps.setString(1, serviceType.getDescription());
            ps.setDouble(2, serviceType.getApproxPrice());
            ps.setInt(3, serviceType.getSubCategoryId());
            if (ps.executeUpdate() != 0) {
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
    
    public static boolean delete(final int serviceTypeId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("update service set deleted = 1 where id = ? ");
            ps.setInt(1, serviceTypeId);
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
    
    public static ServiceType get(final int serviceTypeId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServiceType serviceType = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from service where deleted = 0 and id = ?");
            ps.setInt(1, serviceTypeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                serviceType = new ServiceType();
                serviceType.setId(rs.getInt("id"));
                serviceType.setDescription(rs.getString("description"));
                serviceType.setApproxPrice(rs.getFloat("approx_price"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return serviceType;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return serviceType;
    }
    
    public static List<ServiceType> getServiceTypes(final int subCategoryId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServiceType> serviceTypesList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from service where deleted = 0 and subcategory_id = ? ");
            ps.setInt(1, subCategoryId);
            rs = ps.executeQuery();
            serviceTypesList = new ArrayList<ServiceType>();
            while (rs.next()) {
                final ServiceType serviceType = new ServiceType();
                serviceType.setId(rs.getInt("id"));
                serviceType.setDescription(rs.getString("description"));
                serviceType.setApproxPrice(rs.getFloat("approx_price"));
                serviceType.setSubCategoryId(subCategoryId);
                serviceTypesList.add(serviceType);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return serviceTypesList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return serviceTypesList;
    }
    
    public static List<ServiceType> getForceServiceTypes(final int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServiceType> serviceTypesList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement(" select * from service where deleted=0 and id in(select service_id from skill where user_id=?) ");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            serviceTypesList = new ArrayList<ServiceType>();
            while (rs.next()) {
                final ServiceType serviceType = new ServiceType();
                serviceType.setId(rs.getInt("id"));
                serviceType.setDescription(rs.getString("description"));
                serviceType.setApproxPrice(rs.getFloat("approx_price"));
                serviceType.setSubCategoryId(rs.getInt("subcategory_id"));
                serviceTypesList.add(serviceType);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return serviceTypesList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return serviceTypesList;
    }
    
    public static List<ServiceType> getServiceTypes() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServiceType> serviceTypesList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from service where deleted = 0 ");
            rs = ps.executeQuery();
            serviceTypesList = new ArrayList<ServiceType>();
            while (rs.next()) {
                final ServiceType serviceType = new ServiceType();
                serviceType.setId(rs.getInt("id"));
                serviceType.setDescription(rs.getString("description"));
                serviceType.setApproxPrice(rs.getFloat("approx_price"));
                serviceType.setSubCategoryId(rs.getInt("subcategory_id"));
                serviceTypesList.add(serviceType);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return serviceTypesList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return serviceTypesList;
    }
}