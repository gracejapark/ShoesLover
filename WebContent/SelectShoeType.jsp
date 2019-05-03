<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
body {
    background-color: #92a8d1;
}
</style>
</head>
<body>
<ul>
  <li><a class="active" href="http://localhost:8080/Park_Jungah_MVCApp/HomePage.jsp">Home</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">MAN</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">WOMEN</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">KIDS</a></li>
</ul>
<p align="center"><font color="8000000" size="6"><%="SELECT TYPE" %></font></br></br></br></p>
<h2></h2>
<form method="post" action="Order.jsp"> 
<p align="center"><input type="radio" name="shoeType" id="shoeType" value="men" checked/>
	<label for="men">Men</label>
	<input type="radio" name="shoeType" id="shoeType" value="women"/>
	<label for="women">Women</label>
	<input type="radio" name="shoeType" id="shoeType" value="kids"/>
	<label for="kids">Kids</label></br></br></p> 
<p align="center"><input type="submit" value="Start Order"/></p>
</form>
<form method="post" action="ShowOrderStatus.jsp"> 
<p align="center"><input type="submit" value="Show my order status"/></p>
</form>	
</body>
</html>