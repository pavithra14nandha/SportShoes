    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="java.io.File" %>
    <%@page import="java.util.Base64.*" %>
    <%@ page import="java.nio.file.Files" %>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:20px;color:darkorchid;background-color:honeydew">
<h1 style= "font-size:50px;color:red">
		<center >Sporty shoes</center>
		<h3>Admin Product view Page</h3>
	</h1><hr>
	<table border="1px">
<%List<Product> list=(List<Product>)request.getAttribute("list"); %>
<% for(Product p:list) { %>
<tr><td>
<%=p.getPid() %></td>
<td><%=p.getPname() %></td>
<td><%=p.getPbrand() %></td>
<td><%=p.getPrice() %></td>
<% String filepath=p.getPath();
byte[]images=Files.readAllBytes(new File(filepath).toPath());
byte[] encodeBase64=Base64.getEncoder().encode(images);
String base64Encoded= new String(encodeBase64,"UTF-8");
%>
<td><img alt="img" src="data:image/png;base64,<%=base64Encoded %>"></td></tr>

<%}%>
</table>
</body>
</html>