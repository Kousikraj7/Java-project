<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel=" stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/minty/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<meta charset="ISO-8859-1">
<title>Here ,Your User List</title>
</head>
<body>

	<header>
		<%@ include file="header.html"%></header>
	<h4 style="text-align: center; font-family: cursive; font-size: 50px;">
		User List</h4>

	<div style="margin-left: 999px;">
		<button type="button" class="btn btn-info">
			<a href="./addUser.jsp" style="text-decoration: none; color: white;">Add
				User</a>
		</button>
	</div>
	<div style="margin: 30px;">
		<table class="table table-hover">
			<thead>
				<tr class="table-success">
					<th scope="col">User Id</th>
					<th scope="col">Name</th>
					<th scope="col">MobileNumber</th>
					<th scope="col">CityName</th>
					<th scope="col" style="text-align: center;">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="table" items="${userList}">
					<tr>
						<td><c:out value="${table.userid}" /></td>
						<td><c:out value="${table.name}" /></td>
						<td><c:out value="${table.mobileNumber}" /></td>
						<td><c:out value="${table.cityName}" /></td>
						<td style="text-align: center;"><a
							href="./EditUserServlet?userid=${table.userid}"><button
									type="button" class="btn btn-warning">Edit</button></a>
							&nbsp;&nbsp; <a href="./DeleteUserServlet?userid=${table.userid}"><button
									type="button" class="btn btn-danger">Delete</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer><%@ include file="footer.html"%></footer>

</body>
</html>