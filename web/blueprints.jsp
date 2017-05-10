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
        
        <svg id="top" width="1100" height="1000">
       
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
        
        <g fill="none" stroke="black" stroke-width="1">
        <!-- Bjaelke top -->
        <c:out value="${bjaelkeTop}" escapeXml="false"/>
        
        <!-- Bjaelke bottom -->
        <c:out value="${bjaelkeBund}" escapeXml="false"/>
        </g>
        <!-- Creating spaer -->
        <g fill="#ffffff" stroke="black" stroke-width="1">
        <c:forEach items="${spaer}" var="List">
            <c:out value="${List}" escapeXml="false"/>
        </c:forEach>
        
        <!-- Creating taglaegter -->
        <c:forEach items="${tlUp}" var="List">
            <c:out value="${List}" escapeXml="false"/>
        </c:forEach>
        <c:forEach items="${tlDown}" var="List">
            <c:out value="${List}" escapeXml="false"/>
        </c:forEach>
        
        <!-- Vindkryds* -->
        <c:out value="${vindkryds}" escapeXml="false"/>
        </g>
        
        <g fill="none" stroke="black" >
        <!-- skur outline -->
        <c:out value="${skurOutline}" escapeXml="false" />
        </g>
        
        <!-- skur stolper -->
        <c:out value="${skurStolper}" escapeXml="false" />
        
        <!-- Creating stem -->
        <c:out value="${stem}" escapeXml="false"/>
        
        <!-- Measurements -->
        <g fill="none" stroke="black" stroke-width:2 font-family='Verdana' font-size='10'>
        <c:forEach items="${measurementsTop}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        </g>
        
        </svg>
        <svg id="side" width="1100" height="1000" >
        <!-- stolper -->
        <c:forEach items="${supportPosts}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        <g fill="white" stroke="black" stroke-width="1">
        <c:forEach items="${roofBoards}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        </g>
            
        <g fill="white" stroke="black" stroke-width="1">
        <<c:out value="${sideFlatRoof2}" escapeXml="false" />
        
        </g>
        <!-- skur -->
        <g fill="white" stroke="black" stroke-width="1">
        <c:forEach items="${skurSide}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        </g>
        <g fill="white" stroke="black" stroke-width="1">
        <c:out value="${sideFlatRoof}" escapeXml="false" />
        <c:out value="${roofHorizontal}" escapeXml="false" />
        </g>
        
        <<c:out value="${roofEnds}" escapeXml="false" />
        
        <!-- Measurements -->
        <g fill="none" stroke="black" stroke-width:2 font-family='Verdana' font-size='10'>
        <c:forEach items="${measurementsSide}" var="List">
            <c:out value="${List}" escapeXml="false" />
        </c:forEach>
        
        </g>
        </svg>
    </body>
</html>
