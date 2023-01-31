<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart page</title>
</head>

<body style="font-size:20px;color:darkorchid;background-color:honeydew">
<h1 style= "font-size:50px;color:red">
		<center >Sporty shoes</center>
	</h1>
	
		<hr>
<% float sc=Float.parseFloat(request.getParameter("price"));%>
<% String name=request.getParameter("pname"); %>
<form action="/payment">

<%float price =Float.parseFloat(request.getParameter("price")); %>

<h1>Amount of <%=price %> for shoe </h1>
Enter bank ID(5 or 6):</td><td><input type="number" name="id">
<input type="hidden" name="pname" value=<%=request.getParameter("pname") %>>
<input type="hidden" name="pbrand" value=<%=request.getParameter("pbrand") %>>
<input type="hidden" name="price" value=<%=request.getParameter("price") %>>
<input type="submit" value="make payment" style="font-size: 20px; font-weight: bold; font-family: ariel;text-align:center;" >
</form>
</body>
</html>