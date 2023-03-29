<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<% List<BankAccount> list= (List<BankAccount>)request.getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>Account number</th>
			<th>Account Type</th>
			<th>Customer Name</th>
			<th>Customer ID</th>
			<th>Status</th>
			<th>Change Status</th>
		</tr>
		
		
		<% for(BankAccount bankaccount:list){%>
		<tr>
			<th><%=bankaccount.getAccNo() %></th>
			<th><%=bankaccount.getType() %></th>
			<th><%=bankaccount.getCustomer().getName() %></th>
			<th><%=bankaccount.getCustomer().getCust_id() %></th>
			<th><%=bankaccount.isStatus() %></th>
			<th><a href="changestatus?accNo=<%=bankaccount.getAccNo()%>"><button>Change</button></a>  </th>
		</tr>
		<%} %>
	</table>

</body>
</html>