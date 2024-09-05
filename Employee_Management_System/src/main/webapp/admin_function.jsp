<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="./adminfunction.css">
</head>

<body>
 <nav>
        <img src="https://i.ibb.co/C768382/logo-QSP-removebg-preview.png" alt="logo-QSP-removebg-preview" border="0">
        <Div>Home</Div>
        <input type="search" name="" id="search" placeholder="search Here">
    
    </nav>
    
    <h1 style="color: white;">Welcome Admin Your Operations are</h1><br>
<section  id="mainSection">

    <!-- left Section -->
    <section id="leftSection">

        <section id="AddEmployeeSection">
            <p id="mainhead">Add Employee</p>
            <hr>
<form action="add_emp" method="post">
            <p>ID : <input type="number" name="id" placeholder="Id" style="color: white;" id="custom"></p>
            <p>Name : <input type="text" name="name" placeholder="Name"></p>
            <p>Salary : <input type="text" name="salary" placeholder="Salary"></p>
            <p>Phone : <input type="tel" name="phone" placeholder="Phone"></p>
            <p>Password : <input type="text" name="Password" placeholder="Password"></p>
            <p>Role : <input type="text" name="role" placeholder="Role"></p>
            <input type="submit" id="submit">
              <% 
    String res = (String)request.getParameter("message");%>
    
    <h2><%=res %></h2>
    </form>

        </section>
        <!-- view employee By id section -->

        <section id="viewenterID">
            <p id="mainviewhead">Enter id to view Employee</p>
              <form action="view_emp" method="post">
                <p>Id : <input type="number" name="id" placeholder="ID"></p>
                <input type="submit" id="submitbtnviewenterID">
            </form>
        </section>




        <!-- view data of emp -->

        <section id="dataviewempsection"> 
            <!-- <h1>Employee</h1> -->
            <div id="imgnamediv">    <img src="https://i.ibb.co/RbWGZ2p/person.png" alt="person" border="0"> 
            </div>
           

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





<%} %>
           
        </section>

    </section>




    <!-- Right section -->
    <section id="rightSection">
      <p id="admfun">  Admin Functions</p>
        <div id="addempcard"  class="sqrCards"> <div class="circleDiv" id="addemp"><img src="https://i.ibb.co/yQq92SW/addemp.png" alt="addemp" border="0"></div>
    Add Emp
    </div>
        <div id="viewempcard" class="sqrCards">
            <div class="circleDiv " id="viewemp"><img src="https://i.ibb.co/0KXg6QW/viewemp.png" alt="viewemp" border="0"></div>View Emp</div>
        <a href="viewAll_emp.jsp"><div id="viewallempcard" class="sqrCards"> <div class="circleDiv " id="viewallemp"><img src="https://i.ibb.co/VBb5ycT/viwallemp.png" alt="viwallemp" border="0"></div>View All Emp</div>
        </a>

     
       
       
    </section>
</section>


    
<h2><a href="add_emp.jsp"></a></h2><br>
<h2><a href="view_emp.jsp"></a></h2><br>
<h2><a href="viewAll_emp.jsp"></a></h2><br>

 
    <script src="./adminfunction.js"></script>

</body>
</html>