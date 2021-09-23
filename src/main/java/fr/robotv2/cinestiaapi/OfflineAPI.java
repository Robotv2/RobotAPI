package fr.robotv2.cinestiaapi;

import org.bukkit.Bukkit;

import java.util.UUID;

public class OfflineAPI {

    public static UUID getUUID(String playerName) {
        try {
            return Bukkit.getOfflinePlayer(playerName).getUniqueId();
        }  catch (NullPointerException e) {
            return null;
        }
    }

    public static String getName(UUID playerUUID) {
        try {
            return Bukkit.getOfflinePlayer(playerUUID).getName();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
