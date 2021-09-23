package fr.robotv2.cinestiaapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class InventoryAPI {

    public static void open(Player player, InventoryType type) {
        player.openInventory(Bukkit.createInventory(null, type));
    }
}
