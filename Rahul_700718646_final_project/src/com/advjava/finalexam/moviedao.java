package com.advjava.finalexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class moviedao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public moviedao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			System.out.println(jdbcConnection  + "Hi");
			jdbcConnection = DriverManager.getConnection(
					jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	
	
	public List<Movie> listAllMovies() throws SQLException {
		List<Movie> listMovie = new ArrayList<>();
		
		String sql = "SELECT * FROM movie";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
				
		ResultSet resultSet = statement.executeQuery(sql);


		while (resultSet.next()) {
			int id = resultSet.getInt("movieId");
			String movie_name = resultSet.getString("movie_name");
			String seats_available = resultSet.getString("seats_available ");
			float rating = resultSet.getFloat("rating ");
			String theatre_screen = resultSet.getString("theatre_screen ");
	
			Movie movie1= new Movie(movie1, movie_name, seats_available, price, rating,theatre_screen);
			listMovie .add(movie1);
		
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listMovie  ;
	}
}

	public static Movie getMovie(int id) {
		// TODO Auto-generated method stub
		return null;
	}