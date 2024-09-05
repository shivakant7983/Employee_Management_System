<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./home.css">
</head>
<body>


<nav>
    <img src="https://i.ibb.co/C768382/logo-QSP-removebg-preview.png" alt="logo-QSP-removebg-preview" border="0">
    <Div>Home</Div>
    <input type="search" name="" id="search" placeholder="search Here">

</nav>
<hr>
    <section>
        <!-- <img src="https://i.ibb.co/0m9VSKm/sir-png-Normal.png" alt="sir-png-Normal" border="0"> -->
       
        <div id="rightDiv"><img src="https://i.ibb.co/0m9VSKm/sir-png-Normal.png" alt="555">
            <h2>Founder empSystem</h2>
        <p>
           He inspired, empowered, and gave shape to our futures. Their dedication fuels the journey of knowledge and lights the path to success.</p>
        </div>
        <div id="leftDiv">
            

            <section id="login">
          <div id="buttondsDiv">
            Login/Signup
            <button id="adminbutton">Admin</button>
            <Button id="empbutton">Employee</Button>
          </div>
            </div>

            </section>
        </div>
    
        

    </section>


    <section id="hiddenFormAdmin">
        <h1>Admin Login</h1>
        <form method="get" action="admin_validate">

             <input type="number" name="id" placeholder="USERNAME/ID" ><br>
             <input type="password" name="password" placeholder="PASSWORD" ><br>
            <input type="submit">
            
            </form>
    </section>
    

    <section id="hiddenFormEMP">
        <h1>Employee Login</h1>
        <form method="get" action="emp_validate">

             <input type="number" name="id" placeholder="USERNAME/ID" ><br>
             <input type="password" name="password" placeholder="PASSWORD" ><br>
            <input type="submit">
            
            </form>
    </section>








<script>
let adminButton = document.getElementById("adminbutton");
let empButton = document.getElementById("empbutton");
let hiddenFormAdmin = document.getElementById("hiddenFormAdmin");
let hiddenFormEMP = document.getElementById("hiddenFormEMP");

adminButton.addEventListener("click", () => {
    hiddenFormAdmin.style.display = "flex";
    hiddenFormEMP.style.display = "none"; 
});

empButton.addEventListener("click", () => {
    hiddenFormEMP.style.display = "flex";
    hiddenFormAdmin.style.display = "none"; 
});

</script>
</body>
</html>