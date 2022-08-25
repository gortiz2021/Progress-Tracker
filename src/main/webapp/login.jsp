<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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