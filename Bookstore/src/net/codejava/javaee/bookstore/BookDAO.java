package net.codejava.javaee.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	
	public boolean insertBook(Book book) throws SQLException {
		String sql = "INSERT INTO book (title, author, price, userId) VALUES (?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setFloat(3, book.getPrice());
		statement.setFloat(4, book.getUserId());
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Book> listAllBooks(User user) throws SQLException {
		List<Book> listBook = new ArrayList<>();
		
		String sql = "SELECT * FROM book";
		
		if (user.getUserType().equalsIgnoreCase("user"))
		{
			sql = "SELECT * FROM book WHERE userId =  " + user.getId();
		}
		
		System.out.println("sql is = " + sql);
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
				
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("book_id");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");
			String status = resultSet.getString("status");
			
			
			Book book = new Book(id, title, author, price, status);
			listBook.add(book);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listBook;
	}
	
	public Boolean deleteBook(Book book) throws SQLException {
		String sql = "DELETE FROM book where book_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, book.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}
	
	public boolean updateBook(Book book, String status) throws SQLException {
		String sql = "UPDATE book SET title = ?, author = ?, price = ?";
		sql += "WHERE book_id = ?";
		
		if (status != null) {
			sql = "UPDATE book SET title = ?, author = ?, price = ?, status = " +" '"+status+"' ";
			sql += "WHERE book_id = ?";
		}
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setFloat(3, book.getPrice());
		statement.setInt(4, book.getId());
	
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}	
	
	public Book getBook(int id) throws SQLException {
		Book book = null;
		String sql = "SELECT * FROM book WHERE book_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			float price = resultSet.getFloat("price");
			String status = resultSet.getString("status");
			
			
			book = new Book(id, title, author, price, status);
		}
		
		resultSet.close();
		statement.close();
		
		return book;
	}
}
