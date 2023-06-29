<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Edit User Details</title>
</head>
<body>
	<header>
		<%@ include file="header.html"%></header>
	<h1 style="margin-left: 50px;">Edit User Details</h1>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<form action="./EditUserServlet" method="post">
					<fieldset>
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4">User Id</label> <input type="text"
								class="form-control form-control-sm" name="userid"
								value="${user.userid }" placeholder="Enter userid" readonly />
						</div>
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4">Name</label> <input type="text"
								class="form-control" name="name" value="${user.name }"
								placeholder="Enter User name">
						</div>
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4">Mobile Number</label> <input
								type="number" class="form-control" name="mobilenumber"
								value="${user.mobileNumber }"
								placeholder="Enter user MobilenNumber">
						</div>
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4">City Name</label> <input
								type="text" class="form-control" name="cityname"
								value="${user.cityName}" placeholder="Enter User CityName">
						</div>
						<button type="submit" class="btn btn-primary">Edit User</button>
					</fieldset>
				</form>
			</div>
			<div class="col-6">
				<img src="edituser-img.PNG" alt="EditUser-img"
					style="height: 400px; width: 560px;" />
			</div>
		</div>
	</div>


	<footer><%@ include file="footer.html"%></footer>
</body>
</html>