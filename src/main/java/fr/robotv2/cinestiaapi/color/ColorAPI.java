package fr.robotv2.cinestiaapi.color;

import org.bukkit.ChatColor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ColorAPI {
    
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String uncolorize(String message) {
        return ChatColor.stripColor(message);
    }

    public static List<String> colorize(Collection<String> messages) {
        return messages.stream().map(ColorAPI::colorize).collect(Collectors.toList());
    }

    public static List<String> uncolorize(Collection<String> messages) {
        return messages.stream().map(ColorAPI::uncolorize).collect(Collectors.toList());
    }
}
