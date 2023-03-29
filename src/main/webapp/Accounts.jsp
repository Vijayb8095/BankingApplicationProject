<%@page import="dto.BankAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Account</title>
</head>
<body>

<%List<BankAccount> list=(List<BankAccount>) request.getAttribute("list2"); 
if(list.isEmpty())
{
%>
<h1>No Active Accounts found</h1>
<%}else{ %>
<h1>Select Bank Account</h1>
<%for(BankAccount bankAccount :list) {%>
<a href="setaccount?accNo=<%=bankAccount.getAccNo() %>"> <button><%=bankAccount.getAccNo() %></button> </a><br><br>
<%} %>
<%} %>
<br>

<a href="CustomerHome.html"><button>Back</button></a>
</body>

</html>