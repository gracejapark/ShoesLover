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
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">MAN</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">WOMEN</a></li>
  <li><a href="http://localhost:8080/Park_Jungah_MVCApp/SelectShoeType.jsp">KIDS</a></li>
</ul>
<p align="center"><font color="8000000" size="6"><%="HOME" %></font></br></br></p>

<form method="post" action="CustomerLoginservlet"> 
<p align="center"><input type="radio" name="editList" id="customer" value="customer" checked="checked"/>
<label for="customer">Customer</label>
<input type="radio" name="editList" id="csr" value="csr"/>
<label for="csr">CSR</label></br></br></p>
<p align="center"><input type="submit" value="Select"></br></br></br></p>

<p align="center"><font color="8000000" size="5"><%="RETURNING CUSTOMER" %></font></p> 

<p align="center"><input type="text" name="userName" value="*User Name" onclick="this.value=''"/><br/><br/></p> 
<p align="center"><input type="password" name="password"  value="*Password" onclick="this.value=''"/><br/><br/></p> 
<p align="center"><a href="RegistrationForm.jsp">NEW CUSTOMER</a><br/><br/><br/></p>     
<p align="center"><input type="submit" value="LOGIN"/></p>  

</form>  
</body>
</html>