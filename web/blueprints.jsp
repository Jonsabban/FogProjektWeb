<%-- 
    Document   : blueprints
    Created on : 20-04-2017, 11:07:19
    Author     : alexander
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan tegning</title>
    </head>
    <body>
        <h1>Plan tegning top</h1>
        <svg id="top" width="880" height="850">
        <rect width='<c:out value="${width}" />' height='<c:out value="${height}" />' style="fill:rgb(255,255,255);stroke-width:2px;stroke-style:rgb(0,0,0)" />
        <c:forEach items="${spær}" var="List">
            <p><c:out value="${List}" /></p>
        </c:forEach>
        <rect x="0" y="30" heigth="8" width="<c:out value="${width}" />" style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        <rect x="0" y="<c:out value="${bjælkeBund}" />" heigth="8" width="<c:out value="${width}" />" style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        </svg>
    </body>
</html>
