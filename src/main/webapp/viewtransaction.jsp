<%@page import="dto.Customer"%>
<%@page import="dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="dto.BankAccount"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Transactions</title>
</head>
<body>

	<%Customer customer = (Customer) request.getSession().getAttribute("customer");

if (customer == null) {
	response.getWriter().print("<h1>Session Expired</h1");
	request.getRequestDispatcher("Login.html");

} else { %>
	<%
	long accNo = (long) session.getAttribute("accNo");
	BankDao bankDao = new BankDao();
	BankAccount account = bankDao.find(accNo);
	List<BankTransaction> list = account.getBankTransactions();
	%>
	
	<h1>Account Number: <%=accNo %></h1>
	<h1>Account Type: <%=account.getType() %></h1>
	
	<table border="1">
		<tr>
			<th>Transaction id</th>
			<th>deposit</th>
			<th>withdraw</th>
			<th>balance</th>
			<th>Date</th>
			
		
		</tr>
		
		
		<% for(BankTransaction bankTransaction:list){%>
		<tr>
			<th><%=bankTransaction.getId() %></th>
			<th><%=bankTransaction.getDeposit() %></th>
			<th><%=bankTransaction.getWithdraw()%></th>
			<th><%=bankTransaction.getBalance() %></th>
			<th><%=bankTransaction.getDateTime() %></th>
			
		</tr>
		<%} %>
		</table>
		<br>
		<a href="AccountHome.html"><button>Back</button></a>
		<%} %>
		
</body>
</html>