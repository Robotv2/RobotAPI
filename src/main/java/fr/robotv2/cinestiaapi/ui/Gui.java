package fr.robotv2.cinestiaapi.ui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface Gui extends InventoryHolder {
    String getName(Player player, Object... objects);
    int getSize();
    void contents(Player player, Inventory inv, Object... objects);
    void onClick(Player player, Inventory inv, ItemStack current, int slot);
    void onClose(Player player, InventoryCloseEvent event);
}