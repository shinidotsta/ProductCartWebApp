<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page language="java" import="java.util.*" %> 
    <%--Importing all the dependent classes--%>
<%@page import="com.face.BO.ProductBO"%> 
<!DOCTYPE html>
<html>
<head>
<style>
.submit
 {
  background: none!important;
  border: none;
  padding: 0!important;
  /*optional*/
  font-family: arial, sans-serif;
  /*input has OS specific font-family*/
  color: #069;
  text-decoration: underline;
  cursor: pointer;
}
</style>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title></title>
</head>
<body>
<h3> ${user.userName} ,See products!!!!</h3>


 <table class="table table table-bordered">
        <tr><th>ID</th><th>Product Name</th><th>Quantity</th><th>Price</th><th></th><th></th></tr>
        
    <%ArrayList<ProductBO> productlist=(ArrayList)request.getAttribute("listpdct");
    
    for(int i=0;i<productlist.size();i++)
    {
    int id=productlist.get(i).getId();
    String name=productlist.get(i).getPdctNmae();
    String quantity=productlist.get(i).getQuantity();
    String price=productlist.get(i).getPrice();
    %>
    <form method="POST" action="${pageContext.request.contextPath}/Updation">
    <tr>
     <td><input type="text" name="id" value="<%=id%>"></td> 
      <td><input type="text" name="name" value="<%=name%>"></td> 
      <td><%=quantity %></td><td><%=price %></td>
     <td>
     <input type="submit" class="submit" value="Delete">
     </td>
      <td>
     <input type="submit" class="submit" value="Edit"  onclick="form.action='${pageContext.request.contextPath}/Edit';form.method='post';enable()">
     </td>
     </form>
    </tr>
    <%} %>
 </table>

<script>
function enable() {
	document.getElementById("name").disabled = false;
	}
</script>

</body>
</html>