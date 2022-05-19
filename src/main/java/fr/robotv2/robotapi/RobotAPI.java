package fr.robotv2.robotapi;

import fr.robotv2.robotapi.config.ConfigAPI;
import fr.robotv2.robotapi.ui.GuiAPI;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

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

    public static Logger getLogger() {
        return get().getLogger();
    }
}
