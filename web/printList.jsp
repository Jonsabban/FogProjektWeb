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
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 50px;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
            width: 150px;
        }
        td, th:nth-child(1) {
            width: 100px;
        }
        td, th:nth-child(2) {
            width: 50px;
        }
        td, th:nth-child(3) {
            width: 50px;
        }
        td, th:nth-child(4) {
            width: 50px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
    <body>
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
    </body>
</html>
