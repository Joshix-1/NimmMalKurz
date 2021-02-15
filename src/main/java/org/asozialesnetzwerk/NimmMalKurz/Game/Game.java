package org.asozialesnetzwerk.NimmMalKurz.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private static final ConcurrentHashMap<Integer, Game> games = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Player> players = new ConcurrentHashMap<>();

    private final int gameCode;
    private final ArrayList<Player> playerList = new ArrayList<>();

    private Game(int gameCode) {
        this.gameCode = gameCode;
    }

    synchronized public static Game getOrCreateGame(String gameCodeStr) {
        int gameCode = gameCodeStr.toLowerCase().hashCode();

        if (games.containsKey(gameCode)) {
            return games.get(gameCode);
        } else {
            Game game = new Game(gameCode);
            games.put(gameCode, game);
            return game;
        }
    }

    synchronized public Player getOrCreatePlayer(String playerSessionId) {
        int playerId = playerSessionId.hashCode();
        Player player;

        if (players.containsKey(playerId)) {
            player = players.get(playerId);
        } else {
            player = new Player(playerId);
            players.put(playerId, player);
        }

        if (!playerList.contains(player)) {
            playerList.add(player);
        }

        return player;
    }

    public Player[] getPlayers() {
        return playerList.toArray(new Player[0]);
    }

}
