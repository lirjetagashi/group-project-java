<%--
  Created by IntelliJ IDEA.
  User: Sara Asefi
  Date: 2022-03-04
  Time: 1:51 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Geographic Area Detail</title>
</head>
<body>
<div >
    <h1>GeographicArea Form</h1>
    <form action="<%=request.getContextPath()%>/CanadaCensusController" method="post">
        <input type="hidden" name="pageName" value="geographicAreaDetail">
        <table style="with: 100%">
            <tr>
                <td>Geographic Area ID</td>
                <td><input type="text" name="geographicAreaID" /></td>
            </tr>
            <p><i>${message}</i></p>
        </table>
        <input type="submit" value="sign in" />
    </form>
</div>
</body>
</html>
