package net.codejava.javaee.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		
		bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String action = request.getServletPath();
		
		System.out.println("Hello");
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
			default:
				listBook(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
		private void listBook(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

		List<Book> listBook = bookDAO.listAllBooks(user);
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Book existingBook = bookDAO.getBook(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
		request.setAttribute("book", existingBook);
		request.setAttribute("userType", user.getUserType());

		dispatcher.forward(request, response);
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("user id is = " + user.getId());
		
		Book newBook = new Book(title, author, price, user.getId());
		bookDAO.insertBook(newBook);
		response.sendRedirect("list");
	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		String status = request.getParameter("status");
		Book book = new Book(id, title, author, price);

		System.out.println("book status is = " + status);
		System.out.println("book price is = " + price);
		
		
		if (status != null) {
			book = new Book(id, title, author, price, status);
		}
		
		bookDAO.updateBook(book, status);
		response.sendRedirect("list");
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Book book = new Book(id);
		bookDAO.deleteBook(book);
		response.sendRedirect("list");
	}
}
