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
out.println("Your account number "+rb.getAccno()+" has closed.");
%>
</body>
</html>