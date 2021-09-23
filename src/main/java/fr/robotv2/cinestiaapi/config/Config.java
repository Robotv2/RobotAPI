package fr.robotv2.cinestiaapi.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {

    private final Plugin main;
    private final String name;

    private File database;
    private FileConfiguration databaseConfig;

    private boolean load = false;

    public Config(Plugin main, String name) {
        this.main = main;
        this.name = name;
    }

    public boolean isLoaded() {
        return load;
    }

    public void setup() {
        database = new File(main.getDataFolder(), name + ".yml");
        if(!database.exists()) {
            try {
                if(!database.getParentFile().exists())
                    database.getParentFile().mkdir();
                database.createNewFile();
            } catch(IOException ignored) {
            }
        }
        databaseConfig = YamlConfiguration.loadConfiguration(database);
        load = true;
    }

    public FileConfiguration get() {
        if(isLoaded())
            setup();
        return databaseConfig;
    }

    public void save() {
        try {
            databaseConfig.save(database);
        } catch (IOException ignored) {
        }
    }

    public void reload() {
        databaseConfig = YamlConfiguration.loadConfiguration(database);
    }
}
