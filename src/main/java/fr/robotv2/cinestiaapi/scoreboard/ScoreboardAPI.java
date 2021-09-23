package fr.robotv2.cinestiaapi.scoreboard;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class ScoreboardAPI {
    public static HashMap<Player, FastBoard> boards = new HashMap<>();
    public static FastBoard getBoard(Player player) {
        return boards.get(player);
    }
    public static FastBoard addBoard(Player player) {
        FastBoard board = new FastBoard(player);
        boards.put(player, board);
        return board;
    }
    public static void clearBoard(Player player) {
        FastBoard board = getBoard(player);
        if(board != null) {
            board.delete();
            boards.remove(player);
        }
    }
}
