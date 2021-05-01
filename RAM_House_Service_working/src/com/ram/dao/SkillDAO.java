package com.ram.dao;

import java.util.*;
import java.sql.*;
import com.ram.dto.*;

public class SkillDAO
{
    public boolean addSkill(final Skill skill) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("insert into skill(user_id,service_id, experience,approved) values(?,?,?,'N')");
            ps.setInt(1, skill.getUser().getId());
            ps.setInt(2, skill.getServiceType().getId());
            ps.setInt(3, skill.getExperience());
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
    
    public List<Skill> getSkillsList(final Force force) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Skill> skillsList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from skill where user_id=? ");
            ps.setInt(1, force.getId());
            rs = ps.executeQuery();
            skillsList = new ArrayList<Skill>();
            while (rs.next()) {
                final Skill skill = new Skill();
                final User user = new UserDAO().get(rs.getInt("user_id"));
                skill.setUser(user);
                final ServiceType serviceType = ServiceTypeDAO.get(rs.getInt("service_id"));
                skill.setServiceType(serviceType);
                skill.setExperience(rs.getInt("experience"));
                skill.setCertificateImage(rs.getString("certificate"));
                if (rs.getString("approved").charAt(0) == 'Y') {
                    skill.setApproved(true);
                }
                else {
                    skill.setApproved(false);
                }
                skillsList.add(skill);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return skillsList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return skillsList;
    }
    
    public List<Skill> getUnapprovedSkillsList() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Skill> skillsList = null;
        try {
            con = DBUtility.getConnection();
            ps = con.prepareStatement("select * from skill where approved='N'");
            rs = ps.executeQuery();
            skillsList = new ArrayList<Skill>();
            while (rs.next()) {
                final Skill skill = new Skill();
                final User user = new UserDAO().get(rs.getInt("user_id"));
                skill.setUser(user);
                final ServiceType serviceType = ServiceTypeDAO.get(rs.getInt("service_id"));
                skill.setServiceType(serviceType);
                skill.setExperience(rs.getInt("experience"));
                skill.setCertificateImage(rs.getString("certificate"));
                skill.setApproved(false);
                skillsList.add(skill);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return skillsList;
        }
        finally {
            DBUtility.close(con);
        }
        DBUtility.close(con);
        return skillsList;
    }
}