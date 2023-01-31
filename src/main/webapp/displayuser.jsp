<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*" %>
       <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>users account</title>
</head>
<body style="font-size:25px;color:darkorchid;background-color:honeydew">
<h1 style= "font-size:50px;color:red">
		<center >Sporty shoes</center>
	</h1>
	<h3>Registered User's View Page of Admin</h3>
		<hr>
<table border="3px">
<tr><th>userId</th><th>username</th>
<th>email</th><th>actions</th></tr>
<%List<User> list=(List<User>)request.getAttribute("uu");%>
<% for(User u:list ) {%>
<tr><td><%=u.getUserid() %></td>
<td><%=u.getUsername() %></td>
<td><%=u.getEmail() %></td>
<td><a href="delete.jsp/id=?"<%=u.getUserid() %>>delete</a></td>
</tr>
<%}%>
</table>
</body>
</html>