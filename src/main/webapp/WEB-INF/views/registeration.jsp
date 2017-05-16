<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<!-- 
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> -->
<title>Registration Form</title>
<style type="text/css">
</style>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div align="center"
		style="background-color: lime; text-decoration: none;">
		<a href="${pageContext.request.contextPath}/getUsers">Click To
			view Registered User</a>
	</div>
	<h1 class="register-title">Registration Page</h1>
	<form method="post" class="register"
		action="${pageContext.request.contextPath}/saveUser"
		enctype="multipart/form-data">
		<h2 style="text-align: center; color: navy; font-weight: bold;"
			align="center">${message}</h2>
		<div class="register-switch">
			<input type="radio" name="sex" value="Female" id="sex_f"
				class="register-switch-input" checked /> <label for="sex_f"
				class="register-switch-label">Female</label> <input type="radio"
				name="sex" value="Male" id="sex_m" class="register-switch-input" />
			<label for="sex_m" class="register-switch-label">Male</label>
		</div>
		<input type="text" class="register-input" placeholder="Name"
			name="name" /> <input type="text" class="register-input"
			placeholder="Mobile No" name="contact" /> <input type="email"
			class="register-input" placeholder="Email address" name="email">
		<input type="text" class="register-input" placeholder="Hobbies"
			name="hobbies" /> <input type="text" class="register-input"
			placeholder="Qualification" name="qualification" /> <input
			type="text" class="register-input" placeholder="address"
			name="address" /><input type="text" class="register-input"
			placeholder="Zip code" name="zip" /> <input type="date"
			class="register-input" placeholder="DOB" name="dob" /> <input
			type="file" class="file" placeholder="Image" name="imageFile" /> <input
			type="submit" value="Create Account" class="register-button" />
	</form>
</body>
</html>