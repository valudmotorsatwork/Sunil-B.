<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="styles/kendo.common.min.css"/>
<link rel="stylesheet" href="styles/kendo.default.min.css"/>
<link rel="stylesheet" href="styles/bootstrap.min.css"/>
<link rel="stylesheet" href="css/login.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script> 
 
</head>
<body>
<form action="LoginController" method="post">
<div id="pagewrap">
<div class="wrapper row1">
	<div class="col">
	<h2 id="headingpanel">Login</h2>		
	</div>
	</div>
	<div class="demo-section k-content">
		<div class="row1">
			<div class="col">
				<label for="username">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email</label>
				<kendo:maskedTextBox name="email" rules="String"></kendo:maskedTextBox>
			</div>
			<div class="col">
				<label for="password">Password</label>
				<kendo:maskedTextBox name="password"></kendo:maskedTextBox>
			</div>

			<div class="col">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<kendo:button name="signin" tag="a" enable="true" class="k-primary">
						<kendo:button-content>Sign In</kendo:button-content>
					</kendo:button>
				<kendo:button name="signup" tag="a" enable="true" class="k-primary">
					<kendo:button-content>Sign Up</kendo:button-content>
				</kendo:button>
				</div>
				</div>
	</div>
</div>
</form>
</body>
</html>