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
        <script src="jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="validation.js" type="text/javascript"></script>
        <title>Create Account</title>
    </head>
    <body>
        <header><h1>Johannes Fog - Carport Builder</h1></header>
        <div id="container">
            <form action="SLcreate" method="post" name="createuser" onsubmit="return validateForm()">
                <h3>Username:</h3><input class="login" id="inName" type="text" name="username" placeholder="user1234">
                <h3>Password:</h3><input class="login" id="inPass" type="text" name="password" placeholder="6-12 characters">
                <h3>Address:</h3><input class="login" id="inAdd" type="text" name="address" placeholder="Road street 1">
                <h3>Zipcode:</h3><input class="login" id="inZip" type="text" name="zipcode" placeholder="0000">
                <h3>Phone:</h3><input class="login" id="inPhone" type="text" name="phone" placeholder="00000000">
                <h3>Email:</h3><input class="login" id="inMail" type="text" name="email" placeholder="yourmail@mail.com">
                <input id="button" type="submit" value="Create" />
            </form>
        </div>
    </body>
</html>
