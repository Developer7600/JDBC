<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center;">Welcome to Advance Java</h1>
<form action="LoginController" method="post">
<h3>Login</h3>
<h6 style="color:red;">${errormessage}</h6>
Email:<input type="email" name="email"/><br><br>
Password:<input type="password" name="password"/><br><br>
<input type="submit" value="login"/><br>
<a href="login" >Register here..</a>
</form>
</body>
</html>