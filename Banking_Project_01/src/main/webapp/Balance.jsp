<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.nit.Bank.Bean.RegisterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
RegisterBean rb = (RegisterBean)request.getAttribute("bean");
out.println("Welcome "+rb.getUname()+"<br>");
out.println("======User Balance Details======"+"<br>");
out.println("Account no : "+rb.getAccno()+"<br>");
out.println("UserName : "+rb.getUname()+"<br>");
out.println("Amount : "+rb.getAmt()+"<br>");
out.println("Address : "+rb.getAdr()+"<br>");
out.println("Contact : "+rb.getContact()+"<br>");
%>
</body>
</html>