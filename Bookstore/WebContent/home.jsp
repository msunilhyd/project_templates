<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin CPanel - Bookshop</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Welcome to Workorder Website Panel</h1>
		<b>${user.fullname} (${user.email})</b>
				<h2>
			<a href="${pageContext.request.contextPath}/new">Post your work order</a>
			&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/list">List All your work orders</a>
		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>List of your work orders</h2></caption>
			<tr>
				<th>ID</th>
				<th>Complaint</th>
				<th>Your Name</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${listBook}">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.author}" /> </td>
					<td><c:out value="${book.price}" /> </td>
					<td>
						<a href="${pageContext.request.contextPath}/edit?id=<c:out value='${book.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/delete?id=<c:out value='${book.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<br><br>
		<a href="logout">Logout</a>
	</div>
</body>
</html>