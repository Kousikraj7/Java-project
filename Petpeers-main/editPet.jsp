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
<title>edit pet</title>
</style>
</head>
<body>
	<header>
		<%@ include file="header.html"%></header>
	<h1 style="margin-left: 50px;">Edit Pet Details</h1>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<form action="./EditPetServlet" method="post">
					<fieldset >
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4"></label> <input type="text"
								class="form-control form-control-sm" name="petid"
								value="${pet.petId }" placeholder="Enter petid" readonly>
						</div>
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4">Species Name</label> <input
								type="text" class="form-control" name="speciesname"
								value="${pet.speciesName }" placeholder="Enter SpeciesName">
						</div>
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4">Pet Name</label> <input
								type="text" class="form-control" name="petname"
								value="${pet.petName}" placeholder="Enter Pet Name">
						</div>
						<div class="form-group" style="width: 350px">
							<label class="form-label mt-4">Price</label> <input type="number"
								class="form-control" name="price" value="${pet.price}"
								placeholder="Enter price">
						</div>
						<button type="submit" class="btn btn-primary">Edit Pet</button>
					</fieldset>
				</form>
			</div>
			<div class="col-6">
				<img src="editpet-img.PNG" alt="Editpet-img"
					style="height: 400px; width: 560px;" />
			</div>
		</div>
	</div>


	<footer><%@ include file="footer.html"%></footer>
</body>
</html>