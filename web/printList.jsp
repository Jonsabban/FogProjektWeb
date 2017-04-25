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
        <h2><c:out value="${getcat1}" /></h2>
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
                    <td class="amount"><c:out value="${Tlist.amount}" /></td>
                    <td><c:out value="${Tlist.MPackage}" /></td>
                    <td><c:out value="${Tlist.description}" /></td>                 
                </tr>
            </c:forEach>
        </table>
        <h2><c:out value="${getcat2}" /></h2>
        <table style="width:100%">
            <tr>
                <th>Beskrivelse</th>
                <th>Længde</th> 
                <th>Antal</th>
                <th>Enhed</th>
                <th>Beskrivelse</th>
            </tr>
            <c:forEach items="${TTmaterials}" var="TTlist">
                <tr>
                    <td><c:out value="${TTlist.type}" /></td>
                    <td><c:out value="${TTlist.length}" /></td>
                    <td class="amount"><c:out value="${TTlist.amount}" /></td>
                    <td><c:out value="${TTlist.MPackage}" /></td>
                    <td><c:out value="${TTlist.description}" /></td>                 
                </tr>
            </c:forEach>
        </table>
        <h2><c:out value="${getcat3}" /></h2>
        <table style="width:100%">
            <tr>
                <th>Beskrivelse</th>
                <th>Længde</th> 
                <th>Antal</th>
                <th>Enhed</th>
                <th>Beskrivelse</th>
            </tr>
            <c:forEach items="${TPmaterials}" var="TPlist">
                <tr>
                    <td><c:out value="${TPlist.type}" /></td>
                    <td><c:out value="${TPlist.length}" /></td>
                    <td class="amount"><c:out value="${TPlist.amount}" /></td>
                    <td><c:out value="${TPlist.MPackage}" /></td>
                    <td><c:out value="${TPlist.description}" /></td>                 
                </tr>
            </c:forEach>
        </table>
        <h2><c:out value="${getcat4}" /></h2>
        <table style="width:100%">
            <tr>
                <th>Beskrivelse</th>
                <th>Længde</th> 
                <th>Antal</th>
                <th>Enhed</th>
                <th>Beskrivelse</th>
            </tr>
            <c:forEach items="${BSmaterials}" var="BSlist">
                <tr>
                    <td><c:out value="${BSlist.type}" /></td>
                    <td><c:out value="${BSlist.length}" /></td>
                    <td class="amount"><c:out value="${BSlist.amount}" /></td>
                    <td><c:out value="${BSlist.MPackage}" /></td>
                    <td><c:out value="${BSlist.description}" /></td>                 
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
