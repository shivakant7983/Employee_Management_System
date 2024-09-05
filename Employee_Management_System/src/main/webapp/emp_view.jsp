<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="model.dto.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%


Integer id=(Integer)request.getAttribute("id");
String name = (String)request.getAttribute("name");
Double salary = (Double)request.getAttribute("salary");
Long phone = (Long)request.getAttribute("phone");
String password =  (String)request.getAttribute("password");
String role = (String)request.getAttribute("role");


if(id!=null && name!=null && salary!=null && phone!=null && password!=null && role!=null){
	

%>

<h2>id : <%=id %></h2>
<h2>Name : <%=name %></h2>
<h2>salary : <%=salary %></h2>
<h2>phone : <%=phone %></h2>
<h2>password : <%=password %></h2>
<h2>role : <%=role %></h2>


    out.println("id"+id+"<br>");
    out.println("name"+name+"<br>");
    out.println("salary"+salary+"<br>");
    out.println("phone"+phone+"<br>");
    out.println("password"+password+"<br>");
    out.println("role"+role+"<br>");


<%} %>
</body>
</html>