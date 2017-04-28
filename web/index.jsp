<%-- 
    Document   : index
    Created on : Apr 28, 2017, 11:52:59 AM
    Author     : vfgya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form action="SLlogin" method="GET">
                <h3>Username:</h3><input class="login" type="text" name="username" placeholder="username">
                <h3>Password:</h3><input class="login" type="password" name="password" placeholder="password">
                <input id="button" type="submit" value="login" />
            </form>
        </div>
    </body>
</html>
