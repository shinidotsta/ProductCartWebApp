<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<!-- used to include another pages -->
  <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    <h3>home page</h3>
    demo for simple web application
    <b>It include the following functions:</b>
    <ul>
    <li>Login</li>
      <li>Storing user information in cookies</li>
      <li>Product list</li>
       <li>Create Product</li>
       <li>edit Product</li>
       <li>delete Product</li>
    </ul>
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>