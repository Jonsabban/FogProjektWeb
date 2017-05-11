<%-- 
    Document   : input
    Author     : Mads Andersen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input</title>
        <link href="WebStyle.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <header><h1>Johannes Fog - Carport Builder</h1></header>
        <div id="container">
            <form action="SLBlueprints" method="GET">
                <h3>length:</h3>
                <select class="dd" name="ddLength">
                    <c:forEach items="${lengths}" var="length">
                        <option value="<c:out value="${length}" />"><c:out value="${length}" /> cm</option>
                       
                    </c:forEach>
                         <option value="550">550</option>
                </select>

                <h3>width:</h3>
                <select class="dd" name="ddWidth">
                    <c:forEach items="${widths}" var="width">
                        <option value="<c:out value="${width}" />"><c:out value="${width}" /> cm</option>
                        
                    </c:forEach>
                        <option value="670">670</option>
                </select>


                <h3>tag:</h3>
                <select class="dd" id="roof" name="ddRoof">
                    <option value="fladt">fladt</option>
                    <option value="rejst">rejst</option>
                </select>

                <div id="roofAngle">
                    <h3>rejsning</h3>
                    <select class="dd" name="angle">
                        <option value="15">15 grader</option>
                        <option value="20">20 grader</option>
                        <option value="25">25 grader</option>
                        <option value="30">30 grader</option>
                        <option value="35">35 grader</option>
                        <option value="40">40 grader</option>
                        <option value="45">45 grader</option>

                    </select>
                </div>

                <h3>Inkluder skur:</h3>
                <div class="rbuttons">
                    <input type="radio" name="choice" value="no"  checked="checked"> Nej<br>
                    <input type="radio" name="choice" value="yes"> Ja<br>
                </div>

                <input id="button" type="submit" value="Submit" />
            </form>
        </div>
    </body>
    <script src="jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="validation.js" type="text/javascript"></script>
</html>