package fr.robotv2.cinestiaapi;

import com.google.common.base.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.LinkedList;
import java.util.List;

public class LocationAPI {

    public static String serialize(Location input) {
        double X = input.getX();
        double Y = input.getY();
        double Z = input.getZ();
        float YAW = input.getYaw();
        float PITCH = input.getPitch();
        String WORLD = input.getWorld().getName();

        return X + ";" + Y + ";" + Z + ";" + YAW + ";" + PITCH + ";" + WORLD;
    }

    public static Location deserialize(String input) {
        if(Strings.isNullOrEmpty(input)) return null;
        String[] args = input.split(";");
        if(args.length != 6) return null;

        double X = Double.parseDouble(args[0]);
        double Y = Double.parseDouble(args[1]);
        double Z = Double.parseDouble(args[2]);
        float YAW = Float.parseFloat(args[3]);
        float PITCH = Float.parseFloat(args[4]);
        World WORLD = Bukkit.getWorld(args[5]);

        return new Location(WORLD, X, Y, Z, YAW, PITCH);
    }

    public static List<String> serializeList(List<Location> input) {
        List<String> result = new LinkedList<>();
        input.forEach(loc -> result.add(serialize(loc)));
        return result;
    }

    public static List<Location> deserializeList(List<String> input) {
        List<Location> result = new LinkedList<>();
        input.forEach(locStr -> result.add(deserialize(locStr)));
        return result;
    }
}
