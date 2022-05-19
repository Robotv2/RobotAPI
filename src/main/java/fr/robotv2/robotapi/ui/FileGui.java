package fr.robotv2.robotapi.ui;

import fr.robotv2.robotapi.ItemAPI;
import fr.robotv2.robotapi.RobotAPI;
import fr.robotv2.robotapi.color.ColorAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FileGui extends Gui {

    private String name;
    private int size;

    private final Map<Integer, ItemStack> items = new HashMap<>();

    private final File file;
    private YamlConfiguration config;

    public FileGui(@NotNull File file) {
        this.file = file;
        this.load();
    }

    public FileGui(@NotNull String path) {
        this(new File(Objects.requireNonNull(path)));
    }

    public void load() {
        config = YamlConfiguration.loadConfiguration(file);
        this.name = config.getString("name", "Default name");
        this.size = config.getInt("size", 53) + 1;
        this.loadItems(config);
    }

    private void loadItems(YamlConfiguration config) {
        final ConfigurationSection section = config.getConfigurationSection("items");

        if(section == null) {
            return;
        }

        for(String slotStr : section.getKeys(false)) {

            try {
                final int slot = Integer.parseInt(slotStr) - 1;

                final String name = config.getString("items." + slotStr + ".name");
                final List<String> lore = config.getStringList("items." + slotStr + ".lore");
                final int amount = config.getInt("items." + slotStr + ".amount");


                String materialStr = config.getString("items." + slotStr + ".material", "STONE");
                int durability = 0;

                if(materialStr.contains(":")) {
                    final String[] args = materialStr.split(":");
                    durability = Integer.parseInt(args[1]);
                    materialStr = args[0];
                }

                final Material material = Material.getMaterial(materialStr);
                final ItemStack finalItem = new ItemAPI.ItemBuilder()
                        .setType(material)
                        .setAmount(amount)
                        .setName(name)
                        .setLore(lore)
                        .setDurability(durability)
                        .build();
                items.put(slot, finalItem);

            } catch(NumberFormatException exc) {
                RobotAPI.getLogger().warning(slotStr + " n'est pas un slot acceptable.");
            } catch (IllegalArgumentException exc) {
                RobotAPI.getLogger().warning(config.getString("items." + slotStr + ".material") + " n'est pas un material acceptable.");
            }
        }
    }


    @Override
    public String getName(Player player, Object... objects) {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void contents(Player player, Inventory inv, Object... objects) {
        for(Map.Entry<Integer, ItemStack> entry : items.entrySet()) {
            inv.setItem(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot, @NotNull ClickType clickType) {
        final String slotStr = String.valueOf(slot + 1);
        final ConfigurationSection section = config.getConfigurationSection("items." + slotStr + ".commands");

        if(section == null) return;

        if(clickType == ClickType.LEFT) {
            this.handleCommand(config.getStringList("items." + slotStr + ".commands.left-click"), player);
        } else if(clickType == ClickType.RIGHT) {
            this.handleCommand(config.getStringList("items." + slotStr + ".commands.right-click"), player);
        }
    }

    @Override
    public void onClose(Player player, InventoryCloseEvent event) {}

    private void handleCommand(List<String> commands, Player player) {

        if(commands == null || commands.isEmpty()) {
            return;
        }

        for(String command : commands) {
            final String prefix = command.split(" ")[0];
            final String commandFormatted = command.replace(prefix + " ", "");
            switch (prefix) {
                case "[PLAYER]" -> Bukkit.dispatchCommand(player, commandFormatted.replace("%player%", player.getName()));
                case "[CONSOLE]" -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commandFormatted.replace("%player%", player.getName()));
                case "[CLOSE]" -> player.closeInventory();
                case "[MESSAGE]" -> ColorAPI.sendMessage(player, commandFormatted);
            }
        }
    }
}
