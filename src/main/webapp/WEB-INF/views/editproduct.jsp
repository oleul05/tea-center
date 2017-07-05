<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/teacenter/updateproduct" method="post">
		<input type="hidden" name="id" value="${prd.id}">
		<div class="form-group">
			<label class="control-label col-sm-2">Edit Product:</label>
			<div class="col-sm-4">
				<input type="text" name="editproductname" class="form-control" value="${prd.name}">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Update">
			</div>
		</div>
	</form>
</body>
</html>