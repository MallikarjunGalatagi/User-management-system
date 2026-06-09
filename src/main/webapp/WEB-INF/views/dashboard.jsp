<%@ page import="com.logIn.model.User" %>

<%
User user =
(User)session.getAttribute("loggedInUser");

if(user == null){
    response.sendRedirect("login");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Dashboard</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<div class="container">

    <h2 class="page-title">
        Dashboard
    </h2>

    <div class="info">
        <span class="label">ID :</span>
        <%= user.getId() %>
    </div>

    <div class="info">
        <span class="label">Username :</span>
        <%= user.getUserName() %>
    </div>

    <div class="info">
        <span class="label">Email :</span>
        <%= user.getEmail() %>
    </div>

    <div class="info">
        <span class="label">Mobile Number :</span>
        <%= user.getMobileNo() %>
    </div>

    <div class="info">
        <span class="label">Created At :</span>
        <%= user.getCreatedAt() %>
    </div>

    <div class="button-group">

        <a href="editprofile">
            <button>
                Edit Profile
            </button>
        </a>

        <a href="logout">
            <button>
                Logout
            </button>
        </a>

    </div>

</div>

</body>
</html>