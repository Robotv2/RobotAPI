package fr.robotv2.robotapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;

public class InventoryAPI {

    private static final HashMap<Player, Inventory> inventories = new HashMap<>();

    public static void openLast(Player player) {
        Inventory inventory = inventories.get(player);
        if(inventory == null) return;
        player.openInventory(inventory);
    }

    public static class InventoryBuilder {

        private InventoryHolder holder = null;
        private InventoryType type;
        private boolean save;

        public void open(Player player) {
            if(type == null) return;
            Inventory inventory = Bukkit.createInventory(holder, type);
            if(save)
                inventories.put(player, inventory);
            player.openInventory(inventory);
        }

        public void setType(InventoryType type) {
            this.type = type;
        }

        public void setHolder(InventoryHolder holder) {
            this.holder = holder;
        }

        public void save() {
            this.save = true;
        }
    }
}
