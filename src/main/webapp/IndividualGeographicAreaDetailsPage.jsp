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
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Geographic Area Detail</h1>
    <form action="<%=request.getContextPath()%>/CanadaCensusController" method="post">
            <input type="hidden" name="pageName" value="geographicAreaDetail">
            <label for="geographicAreaID"><b>Geographic Area ID:</b></label>
            <input type="text" placeholder="Enter ID" name="geographicAreaID" id="geographicAreaID"/>
                <p><i>${message}</i></p>
            <input type="submit" name="search" value="Search" class="btn">
    </form>
    <table id="table">
        <tr>
            <th>Name</th>
            <th>Code</th>
            <th>Level</th>
            <th>Total Population</th>
        </tr>
        <tr>
            <td>${geoAreaObj.name}</td>
            <td>${geoAreaObj.code}</td>
            <td>${geoAreaObj.level}</td>
            <td>${totalPopulation}</td>
        </tr>
    </table>
    <h4>Go back to menu: <a href="home.jsp">Main menu</a></h4>
</div>
</body>
</html>
