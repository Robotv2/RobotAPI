package fr.robotv2.robotapi;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

public class OfflineAPI {

    public static UUID getUUID(String playerNAME, boolean force) {
        if(force)
            return Bukkit.getOfflinePlayer(playerNAME).getUniqueId();
        else {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayerIfCached(playerNAME);
            if(offlinePlayer == null)
                return null;
            return offlinePlayer.getUniqueId();
        }
    }

    public static String getName(UUID playerUUID) {
        return Bukkit.getOfflinePlayer(playerUUID).getName();
    }
}
