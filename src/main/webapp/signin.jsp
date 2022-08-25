<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<ul>
	  <li><a href="login.jsp">Already have an account? Login here!</a></li>
	</ul>

    <h1>Sign Up... It's Free :)</h1>
    <form @submit.prevent="signin">
        <fieldset>



            <label>Email:</label>
            <input type="text"  />
            <br>
            <br>

            <label>Password:</label>
            <input type="password" />
            <br>
            <br>



            <input type="submit" value="Sign Up">
        </fieldset>
    </form>


</body>
</html>