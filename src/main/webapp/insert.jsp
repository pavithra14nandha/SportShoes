<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product</title>
</head>
<body style="font-size:30px">
<h1><i>Product Data</i></h1>
<form action="insert" method="post" enctype="multipart/form-data">
Product Name<input type="text" name="name">
Product Brand<input type="text" name="brand">
product price<input type="text" name="price">
Image path<input type="file" name="fpath">
<input type="submit" value="save">
</form>
</body>
</html>