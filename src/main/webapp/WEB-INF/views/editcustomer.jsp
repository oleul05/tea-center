<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer Information</title>
</head>
<body>
	<form action="/teacenter/updatecustomer" method="post">
		<input type="hidden" name="id" value="${cus.id}">
		<div class="form-group">
			<label class="control-label col-sm-2">Username:</label>
			<div class="col-sm-4">
				<input type="text" name="username" class="form-control" value="${cus.username}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Password:</label>
			<div class="col-sm-4">
				<input type="password" name="password" class="form-control" value="${cus.password}" >
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Name:</label>
			<div class="col-sm-4">
				<input type="text" name="name" class="form-control" value="${cus.name}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Surname:</label>
			<div class="col-sm-4">
				<input type="text" name="surname" class="form-control" value="${cus.surname}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Floor:</label>
			<div class="col-sm-4">
				<input type="text" name="floor" class="form-control" value="${cus.floor}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Building:</label>
			<div class="col-sm-4">
				<input type="text" name="building" class="form-control" value="${cus.building}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Room Number:</label>
			<div class="col-sm-4">
				<input type="text" name="roomno" class="form-control" value="${cus.roomno}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Information:</label>
			<div class="col-sm-4">
				<input type="text" name="information" class="form-control" value="${cus.information}">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Edit Customer">
			</div>
		</div>
	</form>
</body>
</html>