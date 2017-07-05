<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Customer</title>
</head>
<body>
	<form action="addCustomerPost" method="post">
		
		<div class="form-group">
			<label class="control-label col-sm-2">Username:</label>
			<div class="col-sm-4">
				<input type="text" name="username" class="form-control" placeholder="Username" required>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Password:</label>
			<div class="col-sm-4">
				<input type="password" name="password" class="form-control" placeholder="Password" required>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Name:</label>
			<div class="col-sm-4">
				<input type="text" name="name" class="form-control" placeholder="Nmae">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Surname:</label>
			<div class="col-sm-4">
				<input type="text" name="surname" class="form-control" placeholder="Surname">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Floor:</label>
			<div class="col-sm-4">
				<input type="text" name="floor" class="form-control" placeholder="Floor">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Building:</label>
			<div class="col-sm-4">
				<input type="text" name="building" class="form-control" placeholder="Building">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Room Number:</label>
			<div class="col-sm-4">
				<input type="text" name="roomno" class="form-control" placeholder="Room Number">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Information:</label>
			<div class="col-sm-4">
				<input type="text" name="information" class="form-control" placeholder="Information">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Add Customer">
			</div>
		</div>
	</form>
</body>
</html>