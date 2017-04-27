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
        <link href="WebStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <header><h1>Johannes Fog - Carport Builder</h1></header>
        <div id="container">
        <!-- Udskriver en array liste med items -->    
        <c:forEach items="${allC}" var="cList">
        <table style="width:100%">
            <tr>
                <th>Beskrivelse</th>
                <th>Længde</th> 
                <th>Antal</th>
                <th>Enhed</th>
                <th>Beskrivelse</th>
            </tr>
            <h2><c:out value="${cList.name}"/></h2>
            <c:forEach items="${allM}" var="mList">
                <c:if test="${cList.id == mList.caID}">
                <tr>
                    <td><c:out value="${mList.type}" /></td>
                    <td><c:out value="${mList.length}" /></td>
                    <td class="amount"><c:out value="${mList.amount}" /></td>
                    <td><c:out value="${mList.MPackage}" /></td>
                    <td><c:out value="${mList.description}" /></td>                 
                </tr>
                </c:if>
            </c:forEach>
        </table>
        </c:forEach>
        </div>
    </body>
</html>
