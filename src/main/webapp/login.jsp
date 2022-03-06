<%--
  Created by IntelliJ IDEA.
  User: Sara Asefi
  Date: 3/5/2022
  Time: 8:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div >
    <form action="<%=request.getContextPath()%>/CanadaCensusController" method="post">
        <div class="container">
            <h1>Sign In</h1>
            <p>Please fill in the form to sign in to CanadaCensusDB.</p>
            <hr>
            <input type="hidden" name="pageName" value="login">

            <label for="username"><b>Username:</b></label>
            <input type="text" placeholder="Enter Username" name="userName" id="username"/>

            <label for="password"><b>Password:</b></label>
            <input type="password" placeholder="Enter Password" name="password" id="password"/>

            <p><i>${message}</i></p>
            <hr>

            <input type="submit" name="submit" value="Submit" class="btn">
        </div>
    </form>
</div>
</body>
</html>
