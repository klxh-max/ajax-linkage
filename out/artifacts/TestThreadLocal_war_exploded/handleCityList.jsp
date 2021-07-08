<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
    </head>
    <body>
        <select id="citySelect">
            <option>==请选择==</option>
            <c:forEach var="city" items="${requestScope.cityArrayList}">
                <option value="${city.cityid}">${city.cityname}</option>
            </c:forEach>
        </select>
    </body>
</html>
