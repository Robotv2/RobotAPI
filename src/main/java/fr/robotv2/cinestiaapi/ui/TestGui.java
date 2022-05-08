package fr.robotv2.cinestiaapi.ui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TestGui implements Gui{

    private Inventory inv;

    @Override
    public String getName(Player player, Object... objects) {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void contents(Player player, Inventory inv, Object... objects) {
        this.inv = inv;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {

    }

    @Override
    public void onClose(Player player, InventoryCloseEvent event) {

    }

    @Override
    public @NotNull Inventory getInventory() {
        return inv;
    }
}
