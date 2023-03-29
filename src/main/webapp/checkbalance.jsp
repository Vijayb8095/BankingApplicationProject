<%@page import="dto.Customer"%>
<%@page import="dto.BankAccount"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Balance</title>
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
	
	%>

	<h1>
		Hello
		<%
	if (customer.getGender().equals("male")) {
	%>Mr.
		<%
	} else {
	%>Ms.<%
	}
	%>
		<%=customer.getName()%></h1>
	<h1>
		Your
		<%=account.getType()%>
		account balance is
		<%=account.getAmount()%></h1>
<%} %>
	<a href="AccountHome.html"><button>Back</button></a>
</body>
</html>