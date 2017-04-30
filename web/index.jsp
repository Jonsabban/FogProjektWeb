<%-- 
    Document   : index
    Created on : Apr 28, 2017, 11:52:59 AM
    Author     : vfgya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="WebStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header><h1>Johannes Fog - Carport Builder</h1></header>
        <div id="container">
            <form action="SLlogin" method="post">
                <h3>Username:</h3><input class="login" type="text" name="username" placeholder="username">
                <h3>Password:</h3><input class="login" type="password" name="password" placeholder="password">
                <c:out value="${fn:escapeXml(param.error)}" />
                <input id="button" type="submit" value="login" />
                <a href="#" class="createLogin">Dont have a account?<br /> create one here</a>
            </form>
        </div>
    </body>
</html>
