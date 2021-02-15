package org.asozialesnetzwerk.NimmMalKurz.Game;

public class Player {
    private final int id;

    private String name;

    public Player(int playerId) {
        this.id = playerId;
        name = GameUtils.generateRandomName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
