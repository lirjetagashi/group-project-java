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
</head>
<body>
<div >
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/CanadaCensusController" method="post">
        <input type="hidden" name="pageName" value="login">
        <table style="with: 100%">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <p><i>${message}</i></p>
        </table>
        <input type="submit" value="sign in" />
    </form>
</div>
</body>
</html>
