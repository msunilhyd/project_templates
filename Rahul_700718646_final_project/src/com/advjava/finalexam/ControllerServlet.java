package com.advjava.finalexam;

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
	private moviedao mdao;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		
		mdao = new moviedao(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/edit":
				showEditForm(request, response);
				break;
			default:
				listMovie(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
		private void listMovie(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
			HttpSession session = request.getSession();
			Movie movie = (Movie) session.getAttribute("movie");

			List<Movie> listMovie = moviedao.listAllMovies();
			request.setAttribute("listMovie", listMovie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();

		Movie existingMovie = moviedao.getMovie(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieForm.jsp");
		request.setAttribute("movie", existingMovie);

		dispatcher.forward(request, response);
	}
	
	
}
