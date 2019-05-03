<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.mvc.ShoesDAO, java.util.List, com.mvc.ShoesBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
table, th, td {
    border: 1px solid black;
}
body {
    background-color: #92a8d1;
}
</style>
<script>
function doOrders() {
	document.getElementById('confirmOrder').action = '/Park_Jungah_MVCApp/ConfirmOrder.jsp';
	document.getElementById('confirmOrder').submit();
}

function cancelOrders() {
	document.getElementById('confirmOrder').action = '/Park_Jungah_MVCApp/HomePage.jsp';
	document.getElementById('confirmOrder').submit();
}
</script>
</head>
<body>
<ul>
 <li><a class="active" href="http://localhost:8080/Park_Jungah_MVCApp/HomePage.jsp">Home</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">MAN</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">WOMEN</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">KIDS</a></li>
</ul>
<p align="center"><font color="8000000" size="6"><%="ORDER" %></font></p>
<h2></h2>
<form method="post" id="confirmOrder" action="ConfirmOrder.jsp">

<table style="width:100%">
  <tr>
  	<th>Select</th>
    <th>Item Id</th>
    <th>Item Name</th> 
    <th>Category</th>
    <th>Shoe Size</th>
    <th>price</th>
  </tr>
<%
  ShoesDAO shoedao = new ShoesDAO();
try { 
	List<ShoesBean> shoes = shoedao.listShoesData(request.getParameter("shoeType")); 
	for (int i = 0; i < shoes.size(); i++) {	
%>	
	<tr>
	<td><input type="radio" name="selectedShoeId" value="<%=shoes.get(i).getItemid()%>" <%=i==0?"checked":""%>></td>
     <td><%=shoes.get(i).getItemid()%></td>
     <td><%=shoes.get(i).getItemname()%></td> 
     <td><%=shoes.get(i).getCategory()%></td>
     <td><%=shoes.get(i).getShoeSize()%></td> 
     <td><%=shoes.get(i).getPrice()%></td>
   </tr>
   <% }
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
</table><br/><br/> 
<input type="button" onClick="doOrders();" value="Order"/>
<input type="button" onClick="cancelOrders();" value="Cancel"/>
</form>
</body>
</html>