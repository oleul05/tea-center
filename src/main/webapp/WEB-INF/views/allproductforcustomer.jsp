<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View And Order Product</title>
</head>
<body>
	<a href="">Update profile</a>
	<a href="">See Order Status</a>
	<form action="">
		<table class="table table-bordered">
			<tr>
				<th>Name</th>
				<th>Quantity</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${product}" var="prod">
				<tr>
					<td>${prod.name}</td>
					<td><input type="text" name="quantity"></td>
					<td><a href="make-order">Order</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>