package fr.robotv2.cinestiaapi;

import fr.robotv2.cinestiaapi.ui.GuiAPI;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class robotAPI extends JavaPlugin {

    public static robotAPI INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        registerListeners();
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new GuiAPI(), this);
    }
}
