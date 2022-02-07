package fr.robotv2.cinestiaapi.message;

import fr.robotv2.cinestiaapi.color.ColorAPI;
import fr.robotv2.cinestiaapi.config.Config;

public class MessageAPI {

    private static Config config;
    private static String prefix;

    public static void setFile(Config config) {
        MessageAPI.config = config;
    }

    public static Config getFile(Config config) {
        return config;
    }

    public static void setPrefix(String prefix) {
        MessageAPI.prefix = ColorAPI.colorize(prefix);
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getMessage(String path, boolean prefix) {
        if(prefix)
            return MessageAPI.prefix + ColorAPI.colorize(config.get().getString(path));
        else
            return ColorAPI.colorize(config.get().getString(path));
    }
}
