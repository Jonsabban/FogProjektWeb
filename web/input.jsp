<%-- 
    Document   : input
    Author     : Mads Andersen
--%>

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
            <form action="SLInput" method="GET">
                <h3>length:</h3>
                <select class="dd" name="ddLength">
                    
                </select>
                
                <h3>width:</h3>
                <select class="dd" name="ddWidth">
                    
                </select>
                
                <h3>tag:</h3>
                <select class="dd" name="ddRoof">
                    <option value="fladt">fladt</option>
                    <option value="rejst">rejst</option>
                </select>
                <input id="button" type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>
