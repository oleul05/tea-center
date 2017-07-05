<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Customer</title>
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th>UserName</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Floor</th>
			<th>Building</th>
			<th>Room No.</th>
			<th>Information</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${customer}" var="cus">
			<tr>
				<td>${cus.username}</td>
				<td>${cus.name}</td>
				<td>${cus.surname}</td>
				<td>${cus.floor}</td>
				<td>${cus.building}</td>
				<td>${cus.roomno}</td>
				<td>${cus.information}</td>
				<td><a href="edit-customer/${cus.id}">Edit</a> <a
					href="deletecustomer/${cus.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>