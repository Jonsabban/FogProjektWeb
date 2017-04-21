<%-- 
    Document   : input
    Author     : Mads Andersen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Her skriver man højde og bredde. Servlet får inputne fra text boksne når man trygger submit -->
        <form action="Servlet" action=measures" method="GET">
            <!-- textbox der tager højde -->
            height: <input type="text" name="height">
            <br />
            <!-- textbox der tager bredde -->
            width: <input type="text" name="width" />
            <br />
            <!-- dropdown liste med tag typer -->
            tag:
            <select>
                <option value="fladt">fladt</option>
                <option value="rejst">rejst</option>
            </select>
            <br />
            <!-- knap der henviser til servlet -->
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
