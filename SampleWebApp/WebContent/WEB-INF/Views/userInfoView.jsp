<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:include page="_header.jsp"></jsp:include>
   <jsp:include page="_menu.jsp"></jsp:include> --%>
   
   <jsp:include page="menu1.jsp"></jsp:include>
    <h3>Hello: ${user.userName}</h3>
    User Name: <b>${user.userName}</b>
  <br />
   Gender: ${user.gender } <br />

      <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>