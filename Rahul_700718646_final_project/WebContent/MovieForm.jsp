<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Work Order Management Application</title>
</head>
<body>
	<center>
		<h1>Work Order Management</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/list">Home</a>

		</h2>
	</center>
	<div align="center">

		<c:if test="${book != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${book == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${book != null }">
						Edit Order
					</c:if>
					<c:if test="${book == null }">
						Add Work Order
					</c:if>
				</h2>
			</caption>
			<c:if test="${book != null}">
				<input type="hidden" name="id" value="<c:out value='${book.id }' />" />
			</c:if>
			<tr>
				<th>Title:</th>
				<td><input type="text" name="title" size="45"
					value="<c:out value='${book.title}' />" /></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="author" size="45"
					value="<c:out value='${book.author }' />" /></td>
			</tr>
			<tr>
				<th>Price:</th>
				<td><input type="text" name="price" size="5"
					value="<c:out value='${book.price}' />" /></td>
			</tr>

			<c:if test="${userType == 'admin'}">

					<h1>It is admin</h1>
				
				<tr>
					<th>Status:</th>
					<td><input type="text" name="status" size="5"
						value="<c:out value='${book.status}' />" /></td>
				</tr>
			</c:if>


			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>