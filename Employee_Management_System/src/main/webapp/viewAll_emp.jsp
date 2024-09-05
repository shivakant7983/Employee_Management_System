<%@page import="java.util.List"%>
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

#btn{
height:0px;
width:0px

}


table{
    border-collapse: separate;

    border-radius: 10px;
    border: 10px solid grey;
     filter: drop-shadow(2px 2px 2px grey);

    td{
        padding: 10px;
        color: white;
        border: solid white;
         font-size: 3vh;
        font-family: system-ui, -apple-system;
    }
    
    
    
    a{
        color: white;
        text-decoration: none;
        font-weight: 900;
        font-size: 4vh;
        font-family: system-ui, -apple-system;
        
    }
}
</style>
<body>

<form action="viewAll_emp" method="post">

 <input type="submit" id="btn">

</form>


    <table border="">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Salary</th>
                <th>Phone</th>
                <th>Password</th>
                <th>Role</th>
            </tr>
        </thead>
        
            <tbody>
                <% 
             
                    List<Employee> allEmployees = (List<Employee>)request.getAttribute("allEmployees");
                    
                    
                    if(allEmployees != null) {
                        for(Employee employee : allEmployees) {
                %>
                <tr>
                    <td><%= employee.getId() %></td>
                    <td><%= employee.getName() %></td>
                    <td><%= employee.getSalary() %></td>
                    <td><%= employee.getPhone() %></td>
                    <td><%= employee.getPassword() %></td>
                    <td><%= employee.getRole() %></td>
                 <td><a href='removeEmployee?id=<%= employee.getId() %>'>Delete</a></td>
                 <td><a href='updateEmployee?id=<%= employee.getId() %>&name=<%= employee.getName() %>&salary=<%= employee.getSalary() %>&phone=<%= employee.getPhone() %>&password=<%= employee.getPassword() %>&role=<%= employee.getRole() %>'>Update</a></td>
                 
                </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        
       </table>

</body>
</html>