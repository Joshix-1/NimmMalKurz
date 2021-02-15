<%@ page import="org.asozialesnetzwerk.NimmMalKurz.Game.Game" %>
<%@ page import="org.asozialesnetzwerk.NimmMalKurz.Game.Player" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nimm mal kurz - Game</title>
</head>
<body>
<h1><%= "Nimm mal kurz!" %></h1>


</body>
</html>

<%
    String gameCode = request.getParameter("game");
    if(gameCode ==null) {
        response.sendRedirect("/");
        return;
    }

    Game game = Game.getOrCreateGame(gameCode);
    Player player = game.addPlayer(request.getSession().getId());
    Player[] players = game.getPlayers();

    System.out.println(Arrays.toString(players));
%>