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
        <!-- Udskriver en array liste med items -->
        <table style="width:100%">
            <tr>
                <th>Beskrivelse</th>
                <th>Længde</th> 
                <th>Antal</th>
                <th>Enhed</th>
                <th>Beskrivelse</th>
            </tr>
            <c:forEach items="${Tmaterials}" var="Tlist">
                <tr>
                    <td><c:out value="${Tlist.type}" /></td>
                    <td><c:out value="${Tlist.length}" /></td>
                    <td><c:out value="${Tlist.amount}" /></td>
                    <td><c:out value="${Tlist.MPackage}" /></td>
                    <td><c:out value="${Tlist.description}" /></td>                 
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
