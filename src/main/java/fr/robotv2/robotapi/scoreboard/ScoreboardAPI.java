package fr.robotv2.robotapi.scoreboard;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreboardAPI {
    private static final Map<UUID, FastBoard> boards = new HashMap<>();

    public static FastBoard getBoard(Player player) {
        return getBoard(player.getUniqueId());
    }

    public static FastBoard getBoard(UUID playerUUID) {
        return boards.get(playerUUID);
    }

    public static FastBoard createOrGetBoard(Player player) {
        if(boards.containsKey(player.getUniqueId())) {
            return getBoard(player);
        }

        final FastBoard board = new FastBoard(player);
        boards.put(player.getUniqueId(), board);
        return board;
    }

    public static void clearBoard(Player player) {
        if(boards.containsKey(player.getUniqueId())) {
            final FastBoard board = getBoard(player);
            board.delete();
            boards.remove(player.getUniqueId());
        }
    }
}
