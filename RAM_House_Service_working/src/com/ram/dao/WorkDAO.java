package com.ram.dao;

import java.sql.*;
import com.ram.dto.*;
import java.util.*;
import java.util.Date;

public class WorkDAO
{
    public boolean addWork(final Work work) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            final String stmt = "insert into work(posted_date,description,status,user_id,service_id,address_id) values(?,?,'O',?,?,?)";
            ps = con.prepareStatement(stmt, 1);
            java.util.Date utilDate = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(1, sqlDate);
            ps.setString(2, work.getDescription());
            ps.setInt(3, work.getPostedBy().getId());
            ps.setInt(4, work.getService().getId());
            ps.setInt(5, work.getAddress().getId());
            if (ps.executeUpdate() > 0) {
                final ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    work.setId(rs.getInt(1));
                    work.setPostedDate(new Date(System.currentTimeMillis()));
                }
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
    
    public Work get(final int workId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Work work = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from work where id = ?");
            ps.setInt(1, workId);
            rs = ps.executeQuery();
            if (rs.next()) {
                work = new Work();
                work.setId(rs.getInt("id"));
                work.setPostedDate(rs.getDate("posted_date"));
                final User user = new UserDAO().get(rs.getInt("user_id"));
                work.setPostedBy(user);
                final ServiceType serviceType = ServiceTypeDAO.get(rs.getInt("service_id"));
                work.setService(serviceType);
                work.setDescription(rs.getString("description"));
                if (rs.getString("status").equals("O")) {
                    work.setStatus(true);
                }
                else {
                    work.setStatus(false);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return work;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return work;
    }
    
    public List<Work> getWorks(final int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Work> worksList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from work;");
//            ps.setInt(1, userId);
            rs = ps.executeQuery();
            worksList = new ArrayList<Work>();
            while (rs.next()) {
                final Work work = new Work();
                work.setId(rs.getInt("id"));
                work.setPostedDate(rs.getDate("posted_date"));
                final User user = new UserDAO().get(rs.getInt("user_id"));
                work.setPostedBy(user);
                final ServiceType serviceType = ServiceTypeDAO.get(rs.getInt("service_id"));
                work.setService(serviceType);
                work.setDescription(rs.getString("description"));
                if (rs.getString("status").charAt(0) == 'O') {
                    work.setStatus(true);
                }
                else {
                    work.setStatus(false);
                }
                worksList.add(work);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return worksList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return worksList;
    }
    
    
    public boolean changeStatus(final int workId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("update work set status = 'C' where id = ?");
            ps.setInt(1, workId);
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