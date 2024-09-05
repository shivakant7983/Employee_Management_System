<%@page import="model.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

    body{
        height: 100vh;
          background-image: url("https://images.pexels.com/photos/326333/pexels-photo-326333.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
          /* background-image: linear-gradient(to left top, #e0b7a9 , #edbbab , #d09eab, #a98eb2,#6d84ae , #1d7a94); */
          position: relative;
          background-size: cover;
          color:white;
          display:flex;
          justify-content:center;
          align-items:center;
     
      }
      

#mainSection{
    height: 80vh;
    width: 32vw;
    display: flex;
    flex-direction: column;
    align-items: center;
    border: solid white;
    text-align: center;
    border-radius: 15px;
    filter: drop-shadow(2px 2px 2px rgb(67, 63, 63));
    box-shadow: 3px 3px 10px white;


    p{
        margin: 2vh 0;
    }

    font-size: 4vh;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
   
    input{
        width: 18vw;
        height: 5vh;
        border-radius: 10px;
        padding-left: 2vw;
        background: transparent;
        /* background-color: aqua; */
        color: aliceblue;
        border: solid aliceblue;

    }

    input::placeholder{
        color: rgb(208, 234, 14);
    }
}

#modify{
    font-size: 5vh;
    color: white;
}


</style>
<body>

<section id="mainSection">
    
    <form action="updateEmployee" method="post">
        <p id="modify">Modify Employee</p>
     <p>   id : <input type="number" name="newid" value='<%=(Integer)request.getAttribute("id")%>' readonly></p>
       <p> name : <input type="text" name="newname" value='<%=(String)request.getAttribute("name") %>'></p>
        <p>salary : <input type="text" name="newsalary" value='<%=(Double)request.getAttribute("salary")%>'></p>
       <p> phone : <input type="tel" name="newphone" value='<%=(Long)request.getAttribute("phone") %>'></p>
     <p>   password : <input type="text" name="newpassword" value='<%=(String)request.getAttribute("password") %>'></p>
       <p> Role : <input type="text" name="newrole" value='<%=(String)request.getAttribute("role")%>'></p>
        <input type="submit">
    </form>
</section>

</body>
</html>