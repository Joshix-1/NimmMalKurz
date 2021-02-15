package org.asozialesnetzwerk.NimmMalKurz.Game;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Game {
    private static final ConcurrentHashMap<Integer, Game> games = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Player> players = new ConcurrentHashMap<>();

    private final int gameCode;
    private final ConcurrentHashMap<Player, Integer> playerMap = new ConcurrentHashMap<>();

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

    synchronized public static Player getOrCreatePlayer(String playerSessionId) {
        int playerId = playerSessionId.hashCode();
        Player player;

        if (players.containsKey(playerId)) {
            player = players.get(playerId);
        } else {
            player = new Player(playerId);
            players.put(playerId, player);
        }
        return player;
    }

    synchronized public Player addPlayer(String playerSessionId) {
        Player player = Game.getOrCreatePlayer(playerSessionId);
        playerMap.put(player, 0);
        return player;
    }

    public Player[] getPlayers() {
        List<Player> playerList = new LinkedList<>();
        playerMap.forEach((player, pw) -> playerList.add(player));
        return playerList.toArray(new Player[0]);
    }

}
