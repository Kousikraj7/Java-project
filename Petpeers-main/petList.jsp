<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel=" stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/minty/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>List of Pets</title>
</head>
<body>

<header>
		<%@ include file="header.html"%></header>
		<h4 style="text-align:center;font-family:cursive;font-size:50px;"> Pet List</h4>		
<div>	
<div style="margin-left:999px;">
<button type="button" class="btn btn-info" ><a href="./addPet.jsp" style="text-decoration:none;color:white;">Add Pet</a></button>
</div>		
   <div style="margin:30px;">
<table class="table table-hover">
  <thead>
    <tr class="table-success">
      <th scope="col">Pet Id</th>
      <th scope="col">Species Name</th>
      <th scope="col">Pet Name</th>
      <th scope="col">Price</th>
       <th scope="col" style="text-align:center;">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="table" items="${petList}">
    <tr>
      <td><c:out value="${table.petId}" /></td>
      <td><c:out value="${table.speciesName}" /></td>
      <td><c:out value="${table.petName}" /></td>
      <td><c:out value="${table.price}" /></td>
      <td style="text-align:center;"><a href="./EditPetServlet?petId=${table.petId}"><button type="button" class="btn btn-warning">Edit</button></a>
			&nbsp;&nbsp;	<a href="./DeletePetServlet?petId=${table.petId}" ><button type="button" class="btn btn-danger">Delete</button></a> </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
         
    <footer><%@ include file="footer.html"%></footer>
</div> 
</body>
</html>