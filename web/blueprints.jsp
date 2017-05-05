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
        
        <!-- Stolper top -->
        <c:forEach items="${stolperTop}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        
        <!-- Stolper bottom -->
        <c:forEach items="${stolperBottom}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        
        <!-- Creating spaer -->
        <g fill="none" stroke="black" stroke-width="1">
        <c:forEach items="${spaer}" var="List">
            <c:out value="${List}" escapeXml="false"/>
        </c:forEach>
        
        <!-- Bjaelke top -->
        <c:out value="${bjaelkeTop}" escapeXml="false"/>
        
        <!-- Bjaelke bottom -->
        <c:out value="${bjaelkeBund}" escapeXml="false"/>

        <!-- Vindkryds* -->
        <c:out value="${vindkryds}" />
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
        <rect x="0" y="<c:out value="${bjaelkeBund}" />" heigth="8" width="<c:out value="${width}" />" style="fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)" />
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
