<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
height:100vh;
display:flex;
justify-contet:center;
align-items:center;
flex-direction:column;
 background-image: linear-gradient(to right top, #e0b7a9 , #edbbab , #d09eab, #a98eb2,#6d84ae , #1d7a94);

input{
height:5vh;
width:18vw
 border-radius: 10vh;


}


}

</style>
<body>
<h1>Welcome Admin</h1>
<section>

<form method="get" action="admin_validate">

ID : <input type="number" name="id" placeholder="Enter iD" >
Password : <input type="password" name="password" placeholder="Enter Password" >
<input type="submit">

</form>
</section>

</body>
</html>