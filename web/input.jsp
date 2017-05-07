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
            <!-- Her skriver man højde og bredde. Servlet får inputne fra text boksne når man trygger submit -->
            <form action="SLInput" method="GET">
                <!-- textbox der tager højde -->
                <h3>length:</h3> <input class="measure" type="text" name="length" placeholder="cm">
                <!-- textbox der tager bredde -->
                <h3>width:</h3> <input class="measure" type="text" name="width" placeholder="cm" />
                <!-- dropdown liste med tag typer -->
                <h3>tag:</h3>
                <select id="dd">
                    <option value="fladt">fladt</option>
                    <option value="rejst">rejst</option>
                </select>
                <!-- knap der henviser til servlet -->
                <input id="button" type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>
