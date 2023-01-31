<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.io.File" %>
    <%@ page import="java.nio.file.Files" %>
    <%@ page import="java.util.Base64.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body style="font-size:30px;color:darkorchid;background-color:honeydew">
<%User u=(User)request.getAttribute("uu"); %>
<h1 style= "font-size:50px;color:red">
		<center >Sporty shoes</center>
	</h1><hr>
<center>	
<i>Hi User !!!!!</i></center>
<form action="getall">
<center>
<input type="submit" value="view Products" style="font-size: 20px; font-weight: bold; font-family: ariel; background-color: #ffedca;">
</center>
</form>



</body>
</html>