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
Double amt = (Double)request.getAttribute("bal");
Double amt1 = (Double)request.getAttribute("amt");
out.println("Receivers balance"+amt1+"<br>");

out.println("Senders money:"+amt+"<br>");
String str = (String)request.getAttribute("msg");
out.println(str);
%>
</body>
</html>