<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">
<title>LogIn</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>
<body>

<div class="container">


<h2 class="page-title">
    LogIn
</h2>

<%
String errorMessage =
(String)request.getAttribute("errorMessage");

String successMessage =
(String)request.getAttribute("successMessage");
%>

<% if(errorMessage != null){ %>
    <div class="error">
        <%= errorMessage %>
    </div>
<% } %>

<% if(successMessage != null){ %>
    <div class="success">
        <%= successMessage %>
    </div>
<% } %>

<form action="login" method="post">

    <input type="text"
           name="loginId"
           placeholder="Username or Email"
           required>

    <div class="password-container">

        <input type="password"
               id="loginPassword"
               name="password"
               placeholder="Password"
               required>

        <span class="toggle-password"
              onclick="toggleLoginPassword()">
            <i class="fa-solid fa-eye"></i>
        </span>

    </div>

    <button type="submit">
        Login
    </button>

</form>

<div class="link">

    Don't have an account?

    <br><br>

    <a href="register">
        Create Account
    </a>

</div>


</div>

<script>

function toggleLoginPassword(){

    var password =
    document.getElementById("loginPassword");

    var eye =
    document.querySelector(".toggle-password i");

    if(password.type === "password"){

        password.type = "text";

        eye.classList.remove("fa-eye");
        eye.classList.add("fa-eye-slash");

    }
    else{

        password.type = "password";

        eye.classList.remove("fa-eye-slash");
        eye.classList.add("fa-eye");

    }
}

</script>

</body>
</html>
