<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
    </head>
    <body>
        <select id="areaSelect">
            <option>==请选择==</option>
            <c:forEach var="area" items="${requestScope.areaArrayList}">
                <option value="${area.aid}">${area.aname}</option>
            </c:forEach>
        </select>
    </body>
</html>
