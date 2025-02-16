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
//out.println("This page belongs to: "+rb.getUname());
String str = (String)request.getAttribute("msg");
out.println(str);
out.println("Total balance is: "+rb.getAmt());
%>
</body>
</html>