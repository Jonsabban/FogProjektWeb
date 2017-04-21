<%-- 
    Document   : blueprints
    Created on : 20-04-2017, 11:07:19
    Author     : alexander
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan tegning</title>
    </head>
    <body>
        <h1>Plan tegning top</h1>
        <svg id="top" width="880" height="850">
        <!-- Outline of the carport 
        Height and width is switched because it is showed sideways.
        -->
        <rect height="<c:out value="${height}" />"
              width="<c:out value="${width}" />" 
              style="fill:rgb(255,255,255);stroke-width:2px;stroke-style:rgb(0,0,0)" />
        
        <!-- Creating spær -->
        <c:forEach items="${spær}" var="List">
            <c:out value="${List}" escapeXml="false"/>
        </c:forEach>
        <!-- Bjælke top *width is height*-->
        <rect x="0" y="30" width="<c:out value="${height}" />" heigth="8" style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        <!-- Bjælke bottom -->
        <rect x="0" y="<c:out value="${bjælkeBund}" />" heigth="8" width="<c:out value="${width}" />" style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        <!-- Stolper top -->
        <rect x="100" y="35" height="10" width="10" style="fill:rgb(0,0,0)" />
        <c:out value="${midTop}" />
        <rect x="<c:out value="${stolpeXBack}" />" y="35" height="10" width="10" style="fill:rgb(0,0,0)" />
        <!-- Stolper top -->
        <rect x="100" y="<c:out value="${bjælkeBund}" />" height="10" width="10" style="fill:rgb(0,0,0)" />
        <c:out value="${midBottom}" />
        <rect x="<c:out value="${stolpeXBack}" />" y="<c:out value="${stolpeY}" />" height="10" width="10" style="fill:rgb(0,0,0)" />
        </svg>
        <svg id="side" >
            
        </svg>
    </body>
</html>
