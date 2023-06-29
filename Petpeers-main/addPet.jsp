<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Add Pet</title>
</head>

<body>
	<header>
		<%@ include file="header.html"%></header>
	<h1 style="margin-left: 50px;">Add Pet Details</h1>
	<div class="container">
	<div class="row">
		<div class="col-6">
			<form action="./AddPetServlet" method="post">
				<fieldset>
					<div class="form-group" style="width: 350px">
						<input type="hidden" class="form-control form-control-sm"
							name="petid" placeholder="Enter petid" required> <label
							class="form-label mt-4">Species Name</label> <select type="text"
							class="form-control" name="speciesname"
							placeholder="Enter Speciesname" required>
							<option value="Dog">Dog</option>
							<option value="cat">Cat</option>
							<option value="Bird">Bird</option>
						</select> <label class="form-label mt-4">Pet Name</label> <input
							type="text" class="form-control" name="petname"
							placeholder="Enter petname" required> <label
							class="form-label mt-4">Pet Price</label> <input type="text"
							class="form-control" name="price" placeholder="Enter petprice"
							required>
					</div>
					<button type="submit" class="btn btn-primary">Add Pet</button>
				</fieldset>
			</form>
		</div>
		<div class="col-6">
			<img src="img/adpetimg.PNG" alt="Addpet-img" style="width:600px;" />
		</div>
	</div>
	</div>

	<footer><%@ include file="footer.html"%></footer>
</body>
</html>