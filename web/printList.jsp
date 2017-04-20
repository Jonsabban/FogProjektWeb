<%-- 
    Document   : newjsp
    Created on : 20-04-2017, 10:27:06
    Author     : vfgya_000
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Material List</title>
    </head>
    <body>
        <c:forEach items="${list}" var="list">
            <p><c:out value="${list}" /></p>
        </c:forEach>
    </body>
</html>
