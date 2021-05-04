<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Movies</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Welcome to Movies Website Panel</h1>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>List of Movies</h2></caption>
			<tr>
				<th>movie_id</th>
				<th>movie_name</th>
				<th>seats_available</th>
				<th>Price</th>
				<th>rating</th>
				<th>theatre_screen</th>
			</tr>
			<c:forEach var="movie" items="${listMovie}">
				<tr>
					<td><c:out value="${movie.movie_id}" /></td>
					<td><c:out value="${movie.movie_name}" /></td>
					<td><c:out value="${movie.seats_available}" /> </td>
					<td><c:out value="${movie.price}" /> </td>
					<td><c:out value="${movie.rating}" /> </td>
					<td><c:out value="${movie.theatre_screen}" /> </td>
<td>
						<a href="${pageContext.request.contextPath}/new?id=<c:out value='${movie.movieId}' />">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>