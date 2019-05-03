<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.mvc.OrdersDAO,java.util.List,com.mvc.OrdersBean,com.mvc.CustomerDAO,com.mvc.CustomerBean,com.mvc.OrderResultBean"%>
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
<p align="center"><font color="8000000" size="6"><%="ORDER STATUS" %></font></p>
<h2></h2>

<form method="post" id='selectShoeType' action="/Park_Jungah_MVCApp/SelectShoeType.jsp">
<%
    CustomerDAO custdao = new CustomerDAO();
	CustomerBean customerbean = custdao.search((String)request.getSession().getAttribute("userName"));
	
 	OrdersDAO orderdao = new OrdersDAO();
 	List<OrderResultBean> orders = null;
	orders = orderdao.listOrderData(customerbean.getCustid());
%>  

<table style="width:100%">
  <tr>
  	<th>Order Id</th>
    <th>Shoe Type</th>
    <th>Shoe Category</th>
    <th>Item Name</th> 
    <th>Shoe Type</th>
    <th>Shoe Size</th>
    <th>Shoe Price</th>
    <th>Order Status</th>
  </tr>

<% 
	double totalPrice = 0.0;
	for(int i = 0 ; i < orders.size(); i++) {
		OrderResultBean orderInfo = orders.get(i);	
		totalPrice += orderInfo.getPrice();
%>
		<input type="hidden" name="orderIds[]" value="<%=orderInfo.getOrderid()%>">
		<tr>
			<td><%=orderInfo.getOrderid()%></td>
			<td><%=orderInfo.getShoeType()%></td>
			<td><%=orderInfo.getCategory()%></td>
			<td><%=orderInfo.getItemname()%></td>
			<td><%=orderInfo.getShoeType()%></td>
			<td><%=orderInfo.getShoeSize()%></td>
			<td><%=orderInfo.getPrice()%></td>
			<td><%=orderInfo.getStatus()%></td>
		</tr>
<% 
	}
%>
<p align="center">Total amount: <%=totalPrice%><br/></p> 
<p align="center"><input type="submit" value="Continue to Select Shoe Type"/></p>
</form>
</body>
</html>