<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Hello: ${user.userName}</h3>
<form method="POST" action="${pageContext.request.contextPath}/AddProduct">
<table>
		<tr>
		<td>ProductName:</td>
		<td><input type="text" name="productname"></td>
		</tr>
		<tr>
		<td> Quantity</td>
		<td><input type="text" name="quantity"></td>
		</tr>
		<tr>
		<td>Price:</td>
		<td><input type="text" name="price"></td>
		</tr>
		
		<input type="submit" value="Add">
	
</table>
	</form>
</body>
</html>