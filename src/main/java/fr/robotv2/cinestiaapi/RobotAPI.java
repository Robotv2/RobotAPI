package fr.robotv2.cinestiaapi;

import fr.robotv2.cinestiaapi.config.ConfigAPI;
import fr.robotv2.cinestiaapi.ui.GuiAPI;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RobotAPI {

    public static JavaPlugin instance;

    public static void initialize(JavaPlugin plugin) {
        instance = plugin;
        ConfigAPI.init(plugin);
        registerListeners();
    }

    private static void registerListeners() {
        PluginManager pm = instance.getServer().getPluginManager();
        pm.registerEvents(new GuiAPI(), instance);
    }

    public static JavaPlugin get() {
        return instance;
    }
}
