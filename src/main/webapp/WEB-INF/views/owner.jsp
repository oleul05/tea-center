<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner Control panel</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-sm-10 col-sm-offset-1">
			<h2>Hello <%=session.getAttribute("username")%></h2>
			<p><a href="add-product">Add New Product</a></p>
			<p><a href="">Edit Product</a></p>
			<p><a href="">Delete Product</a></p>
			
			<p><a href="add-customer">Add New Customer</a></p>
			<p><a href="">Edit Customer</a></p>
			<p><a href="">Delete Customer</a></p>
			
			<p><a href="">View Order</a></p>
			<p><a href="">Update Order Status</a></p>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>