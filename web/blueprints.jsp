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
        <svg id="top" width="1000" height="1000">
        <!-- Outline of the carport -->
        <rect x="100" y="100" height="<c:out value="${height}" />"
              width="<c:out value="${width}" />" 
              style="fill:rgb(255,255,255);stroke-width:2px;stroke:rgb(0,0,0)" />
        
        <!-- Creating spær -->
        <c:forEach items="${spær}" var="List">
            <c:out value="${List}" escapeXml="false"/>
        </c:forEach>
        
        <!-- Bjælke top -->
        <rect x="100" y="130" height="8" width="<c:out value="${width}" />" 
              style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        <!-- Bjælke bottom -->
        <rect x="100" y="<c:out value="${bjælkeBund}" />" height="8" 
              width="<c:out value="${width}" />" 
              style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        
        <!-- Stolper top -->
        <rect x="200" y="130" height="10" width="10" style="fill:rgb(0,0,0)" />
        <c:out value="${midTop}" />
        <rect x="<c:out value="${stolpeXBack}" />" y="130" height="10" width="10" 
              style="fill:rgb(0,0,0)" />
        <!-- Stolper bottom -->
        <rect x="200" y="<c:out value="${bjælkeBund}" />" height="10" width="10" 
              style="fill:rgb(0,0,0)" />
        <c:out value="${midBottom}" />
        <rect x="<c:out value="${stolpeXBack}" />" y="<c:out value="${bjælkeBund}" />" 
              height="10" width="10" style="fill:rgb(0,0,0)" />
        
        <!-- Vindkryds -->
        <g fill="none" stroke="black" stroke-width="1">
        <path stroke-dasharray="5,5" d="M155 135 L<c:out value="${(width+100)-55}" /> <c:out value="${bjælkeBund}" /> 
              L<c:out value="${(width+100)-50}" /> <c:out value="${bjælkeBund}" /> L160 135 Z"/>
        <path stroke-dasharray="5,5" d="M155 <c:out value="${bjælkeBund}" /> L<c:out value="${(width+100)-55}" /> 135
              L<c:out value="${(width+100)-50}" /> 135 L160 <c:out value="${bjælkeBund}" /> Z" />
        </g>
        
        </svg>
        <svg id="side" >
            
        </svg>
    </body>
</html>
