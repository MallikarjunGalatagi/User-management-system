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
<title>Edit Profile</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<div class="container">

    <h2 class="page-title">
        Edit Profile
    </h2>

    <form action="updateProfile" method="post">

        <input type="hidden"
               name="id"
               value="<%= user.getId() %>">

        <input type="text"
               name="userName"
               value="<%= user.getUserName() %>"
               placeholder="Username"
               required>

        <input type="email"
               name="email"
               value="<%= user.getEmail() %>"
               placeholder="Email"
               required>

        <input type="text"
               name="mobileNo"
               value="<%= user.getMobileNo() %>"
               placeholder="Mobile Number"
               maxlength="10"
               required>

        <input type="password"
               name="password"
               value="<%= user.getPassword() %>"
               placeholder="Password"
               required>

        <button type="submit">
            Update Profile
        </button>

    </form>

    <div class="link">

        <a href="dashboard">
            Back To Dashboard
        </a>

    </div>

</div>

</body>
</html>