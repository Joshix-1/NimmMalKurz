package org.asozialesnetzwerk.NimmMalKurz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class GameUtils {

    public static String generateRandomPlayerName() {
        return "player" + System.nanoTime();
    }

    public static String readFromResources(String resource) {
        return new BufferedReader(
                new InputStreamReader(GameUtils.class.getResourceAsStream("/" + resource), StandardCharsets.UTF_8)
        ).lines().collect(Collectors.joining("\n"));
    }
}
