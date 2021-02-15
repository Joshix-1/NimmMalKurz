package org.asozialesnetzwerk.NimmMalKurz;

import org.asozialesnetzwerk.NimmMalKurz.Game.Game;
import org.asozialesnetzwerk.NimmMalKurz.Game.Player;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Game", value = "/game")
public class GameHandler extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String gameCode = request.getParameter("game");
        Game game = Game.getOrCreateGame(gameCode);
        Player player = game.getOrCreatePlayer(request.getSession().getId());

        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + gameCode + "</h1>");
        out.println("player:" + player);
        out.println("<br>");
        out.println("players:" + Arrays.toString(game.getPlayers()));

        out.println("</body></html>");
    }

    public void destroy() {}
}