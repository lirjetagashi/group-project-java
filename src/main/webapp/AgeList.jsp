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
    <title>Age List</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Age List</h1>
    <form action="<%=request.getContextPath()%>/CanadaCensusController" method="post">
        <input type="hidden" name="pageName" value="agePage">
        <label for="censusYear"><b>Census Year:</b></label>
        <input type="text" placeholder="Enter Year" name="censusYear" id="censusYear"/>
        <p><i>${message}</i></p>
        <input type="submit" name="search" value="Search" class="btn">
    </form>
    <table id="table">
        <tr>
            <th>Census Year</th>
            <th>Male Population</th>
            <th>Female Population</th>
        </tr>
        <tr>
            <td>${ageObj.censusYear}</td>
            <td>${ageObj.male}</td>
            <td>${ageObj.female}</td>
        </tr>
    </table>
    <h4>Go back to menu: <a href="home.jsp">Main menu</a></h4>
</div>
</body>
</html>
