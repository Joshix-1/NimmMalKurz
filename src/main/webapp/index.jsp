<%@ page import="org.asozialesnetzwerk.NimmMalKurz.Game.Game" %>
<%@ page import="org.asozialesnetzwerk.NimmMalKurz.Game.Player" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nimm mal kurz - Lobby</title>
</head>
<body>
<h1><%= "Nimm mal kurz!" %>
</h1>
<br/>
<form action="game" method="get">
    <label>
        Gebe einen Game-Code ein:
        <input name="game" type="text">
    </label>
    <input type="submit" value="Starte Spiel.">
</form>

</body>
</html>
