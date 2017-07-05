<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<title>Tea Center web Application</title>
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		
	</head>
<body>
	<div class="row vertical-offset-100 main">
		<div class="col-md-4 col-md-offset-4 col-xs-10 col-xs-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row-fluid user-row">
						<h4 class="text-center">Tea Center web Application</h4>
					</div>
				</div>
				<div class="panel-body">
					<form accept-charset="UTF-8" class="form-signin" action="customer-login" method="post">
						<fieldset>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon user_id">Username</span> 
									<input name="username" type="text" class="form-control login_input" placeholder="Username" required>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon user_id">Password</span> 
									<input name="password" type="password" class="form-control login_input" required placeholder="Password" >
								</div>
							</div>
							<span class="error" id="errorMsg"> <p> ${message}</p></span> <br></br> 
							<input type="submit" value="Sign In »" class="btn btn-lg btn-primary btn-block" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    
</body>
</html>
