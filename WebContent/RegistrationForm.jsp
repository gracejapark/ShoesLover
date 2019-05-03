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
table, th, td {
    border: 1px solid black;
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
<p align="center"><font color="8000000" size="6"><%="REGISTRATION FORM" %></font><br/><br/></p>

<form method="post" action="SelectShoeType.jsp">  

<p align="center"><input type="text" name="userName" value="*User Name" onclick="this.value=''"/><br/></p> 
<p align="center"><input type="password" name="password"  value="*Password" onclick="this.value=''"/><br/></p> 
<p align="center"><input type="text" name="firstname"  value="*First Name" onclick="this.value=''"/><br/></p>  
<p align="center"><input type="text" name="lastname"  value="*Last Name" onclick="this.value=''"/><br/></p>  
<p align="center"><input type="text" name="address"  value="*Address" onclick="this.value=''"/><br/></p> 
<p align="center"><input type="text" name="city"  value="*City" onclick="this.value=''"/><br/></p>
<p align="center"><input type="text" name="postalCode"  value="*Postal Code" onclick="this.value=''"/><br/><br/></p>         
<p align="center"><input type="submit" value="REGISTER"/></p> 
<p align="center"><input type="submit" value="CANCLE"/><a href="http://localhost:8080/Park_Jungah_MVCApp/HomePage.jsp"></a></p>  
</form>
  
</body>
</html>