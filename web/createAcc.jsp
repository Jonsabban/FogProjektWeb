<%-- 
    Document   : createAcc
    Created on : Apr 28, 2017, 2:39:35 PM
    Author     : vfgya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="WebStyle.css" rel="stylesheet" type="text/css"/>
        <title>Create Account</title>
    </head>
    <body>
        <header><h1>Johannes Fog - Carport Builder</h1></header>
        <div id="container">
            <form action="SLlogin" method="post">
                <h3>Username:</h3><input class="login" type="text" name="username" placeholder="username">
                <h3>Password:</h3><input class="login" type="text" name="password" placeholder="password">
                <h3>Address:</h3><input class="login" type="text" name="address" placeholder="address">
                <h3>Zipcode:</h3><input class="login" type="text" name="zipcode" placeholder="zipcode">
                <h3>Phone:</h3><input class="login" type="text" name="phone" placeholder="phone">
                <h3>Email:</h3><input class="login" type="text" name="email" placeholder="email">
                <input id="button" type="submit" value="create" />
            </form>
        </div>
    </body>
</html>
