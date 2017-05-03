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
        <c:out value="${outline}" escapeXml="false"/>
        
        <!-- Creating spær -->
        <c:forEach items="${spær}" var="List">
            <c:out value="${List}" escapeXml="false"/>
        </c:forEach>
        
        <!-- Bjælke top -->
        <c:out value="${bjælkeTop}" escapeXml="false"/>
        
        <!-- Bjælke bottom -->
        <c:out value="${bjælkeBund}" escapeXml="false"/>
        
        <!-- Stolper top -->
        <rect x="200" y="130" height="10" width="10" style="fill:rgb(0,0,0)" />
        <c:out value="${midTop}" />
        <rect x="<c:out value="${stolpeXBack}" />" y="130" height="10" width="10" 
              style="fill:rgb(0,0,0)" />
        <!-- Stolper bottom -->
        <rect x="200" y="<c:out value="${stolpe}" />" height="10" width="10" 
              style="fill:rgb(0,0,0)" />
        <c:out value="${midBottom}" />
        <rect x="<c:out value="${stolpeXBack}" />" y="<c:out value="${stolpe}" />" 
              height="10" width="10" style="fill:rgb(0,0,0)" />
        
        <!-- Vindkryds -->
        <g fill="none" stroke="black" stroke-width="1">
        <path stroke-dasharray="5,5" d="M155 135 L<c:out value="${(width+100)-55}" /> <c:out value="${stolpe}" /> 
              L<c:out value="${(width+100)-50}" /> <c:out value="${stolpe}" /> L160 135 Z"/>
        <path stroke-dasharray="5,5" d="M155 <c:out value="${stolpe}" /> L<c:out value="${(width+100)-55}" /> 135
              L<c:out value="${(width+100)-50}" /> 135 L160 <c:out value="${stolpe}" /> Z" />
        </g>
        
        <!-- Measurements -->
        <g fill="none" stroke="black" stroke-width:2 font-family='Verdana' font-size='10'>
        <c:forEach items="${measurementsTop}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        
        </g>
        
        
        </svg>
        <svg id="side" width="1000" height="1000" >

        <rect x="0" y="30" heigth="8" width="<c:out value="${width}" />" style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        <rect x="0" y="<c:out value="${bjælkeBund}" />" heigth="8" width="<c:out value="${width}" />" style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
        <c:forEach items="${supportPosts}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        <g fill="white" stroke="black" stroke-width="1">
        <c:out value="${sideFlatRoof}" escapeXml="false" />
        <c:out value="${sideFlatRoof2}" escapeXml="false" />
        </g>
        <!-- Measurements -->
        <g fill="none" stroke="black" stroke-width:2 font-family='Verdana' font-size='10'>
        <c:forEach items="${measurementsSide}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        
        </g>
        </svg>
    </body>
</html>
