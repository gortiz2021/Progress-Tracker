<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>

<html>

	<head>
 <!--  		<link rel="stylesheet" href="C:\JavaWorkspace\ProgressTracker\src\main\webapp\styles.css">-->
 
 		
		<style>
		        <%@ include file="styles.css"%>
		 </style>
	</head>
	
	<body>
	
		
		
		<ul>
		  <li><a href="./">Home</a></li>
	
		  <li><a href="login.jsp">Login</a></li>
		</ul>
		
		<h1>TeleTimeline</h1>
		
		<p>Test paragraph</p>

		<form method="post">
	
			<table border="2">
				<tr>
					<td>TV Show ID</td>
					<td>TV Show Name</td>
					<td>TV Show Director</td>
					<td>TV Show Number of Seasons</td>
					<td>TV Show Number of Episodes</td>
					<td>TV Show Genre</td>
					<td>TV Show Audience Score</td>
					<td>TV Show Rating</td>
					<td>TV Show First Episode Name</td>
					<td>TV Show Status</td>
				</tr>
				<%
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/progress_tracker";
					String username = "root";
					String password = "root";
					String query = "select * from tv_show";
					Connection conn = DriverManager.getConnection(url, username, password);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
				%>
				<tr>
					<td><%=rs.getInt("tv_show_id")%></td>
					<td><%=rs.getString("tv_show_name")%></td>
					<td><%=rs.getString("tv_show_director")%></td>
					<td><%=rs.getString("tv_show_number_of_seasons")%></td>
					<td><%=rs.getString("tv_show_number_of_episodes")%></td>
					<td><%=rs.getString("tv_show_genre")%></td>
					<td><%=rs.getString("tv_show_audience_score")%></td>
					<td><%=rs.getString("tv_show_rating")%></td>
					<td><%=rs.getString("tv_show_first_episode_name")%></td>
					<td><%=rs.getString("tv_show_status")%></td>
				</tr>
	
				<%
				}
				%>
			</table>
			<%
			rs.close();
			stmt.close();
			conn.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
		</form>
	
	</body>


</html>