package com.ram.dao;


import java.sql.*;


import com.ram.dto.*;

public class ForceDAO {

	public Force login(String email, String password) {

		Connection con = null;
		PreparedStatement ps = null;
		Force force = null;	

		System.out.println("Logging in as force");
		System.out.println("email = " + email);
		System.out.println("pass = " + password);
		
		
		try {

			con = DBUtility.getConnection();
			ps = con.prepareStatement("select * from user where email = ? and password = ? and role='force' ");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				force = new Force();
				force.setId(rs.getInt("id"));
				force.setName(rs.getString("name"));
				force.setPassword(rs.getString("password"));
				force.setEmailId(rs.getString("email"));
				force.setMobileNumber(rs.getLong("mobile_number"));
				force.setRegistrationDate(rs.getDate("register_date"));
			
				return force;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {			
			DBUtility.close(con);
		}

		return force;
	}
	
	
	public static Force register(Force force) {
		Connection con = null;
		PreparedStatement ps = null;	
		
		if(search(force.getEmailId()))
			return null;
		
		try {
			con = DBUtility.getConnection();
			
			ps = con.prepareStatement("insert into user(name,password,email,register_date,mobile_number,aadhar_image,role) values(?,?,?,?,?,?,'force')",PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, force.getName());
			ps.setString(2, force.getPassword());
			ps.setString(3, force.getEmailId());
			ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			ps.setLong(5, force.getMobileNumber());
			ps.setString(6, force.getAadharImage());

			
			if (ps.executeUpdate() > 0) {				
				
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					force.setId(rs.getInt(1));
				}
				
			    return force;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {			
			DBUtility.close(con);
		}

		return null;
	}
	
	
	private static boolean search(String email)
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {

			con = DBUtility.getConnection();			
			ps = con.prepareStatement("select * from user where email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
				return true;			
		} 
		catch (SQLException e) {
			e.printStackTrace();			
		}		
		
		finally {			
			DBUtility.close(con);
		}
		
		return false;
	}
	

	public Force get(int userId) {

		Connection con = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		Force force = null;

		try {
			con = DBUtility.getConnection();
			ps = con.prepareStatement("select * from user where id = ? and role='force'");
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			if (rs.next()) {
				force = new Force();
				force.setId(rs.getInt("id"));
				force.setName(rs.getString("name"));
				force.setPassword(rs.getString("password"));
				force.setEmailId(rs.getString("email"));
				force.setMobileNumber(rs.getLong("mobile_number"));
				force.setRegistrationDate(rs.getDate("register_date"));
				force.setAadharImage(rs.getString("aadhar_image"));				

				return force;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {			
			DBUtility.close(con);
		}

		return force;
	}

	public Force get(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Force force = null;
		try {
			con = DBUtility.getConnection();
			ps = con.prepareStatement("select * from user where email = ? and role='force'");
			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				force = new Force();
				force.setId(rs.getInt("id"));
				force.setName(rs.getString("name"));
				force.setPassword(rs.getString("password"));
				force.setEmailId(rs.getString("email"));
				force.setMobileNumber(rs.getLong("mobile_number"));
				force.setRegistrationDate(rs.getDate("register_date"));
				force.setAadharImage(rs.getString("aadhar_image"));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {			
			DBUtility.close(con);
		}

		return force;
	}
	
	
	
	public boolean approveForce(int userId, int serviceId, char status){
		Connection con = null;
		PreparedStatement ps = null;
		
		try{			
				con = DBUtility.getConnection();
				ps = con.prepareStatement("update skill set approved = ? where user_id = ? and service_id = ?");
				ps.setString(1, String.valueOf(status));
				ps.setInt(2, userId);	
				ps.setInt(3, serviceId);

				if(ps.executeUpdate()>0)
					return true;					
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {			
			DBUtility.close(con);
		}
		
		return false;
		
	}		

}


