<%--
  Created by IntelliJ IDEA.
  User: lirjeta
  Date: 2022-03-04
  Time: 1:50 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Geographic Area Classification List</title>
</head>

<h1>Geographic Area Classification List</h1>
<h4>Geographic Area Level</h4>
<form action="<%=request.getContextPath()%>/CanadaCensusController" method="post">
    <input type="hidden" name="pageName" value="GeographicAreaClassificationList">
    <button name="level" value="0">The country of Canada</button>
    <button name="level" value="1">Provinces and Territories</button>
    <button name="level" value="2">Census metropolitan areas (CMA) and census agglomerations (CA)</button>
    <button name="level" value="3">One CMA and three CAs</button>
</form>
<body>
    <table>
        <thead>
            <th>Name</th>
        </thead>
        <tbody>
        <c:forEach items="${geoAreaObjList}" var="geoAreaObj">
            <tr>
                <td>
                    ${geoAreaObj.name}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
