<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
	</head>
	<body>
		<h1>Login</h1>
	    <form @submit.prevent="login">
	        <fieldset>
	            <legend>Login Required</legend>
	
	
	
	            <label>Email:</label>
	            <input type="text"  />
	            <br>
	            <br>
	
	            <label>Password:</label>
	            <input type="password" />
	            <br>
	            <br>
	            <input type="submit" value="Login">
	        </fieldset>
	    </form>
	</body>
</html>