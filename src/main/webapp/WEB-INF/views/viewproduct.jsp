<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Product</title>
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${product}" var="prod" >
		<tr>
			<td>${prod.name}</td>
			<td> 
				<a href="edit-product/${prod.id}">Edit</a>
				<a href="deleteproduct/${prod.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>