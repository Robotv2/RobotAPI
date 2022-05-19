package fr.robotv2.robotapi;

import com.google.common.base.Strings;
import fr.robotv2.robotapi.misc.ListConverter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LocationAPI {

    public static String serialize(@Nullable Location input) {

        if(input == null) {
            return null;
        }

        double X = input.getX();
        double Y = input.getY();
        double Z = input.getZ();
        float YAW = input.getYaw();
        float PITCH = input.getPitch();
        String WORLD = input.getWorld().getName();

        return X + ";" + Y + ";" + Z + ";" + YAW + ";" + PITCH + ";" + WORLD;
    }

    public static Location deserialize(String input) {

        if(Strings.isNullOrEmpty(input)) {
            return null;
        }

        String[] args = input.split(";");

        if(args.length != 6) {
            return null;
        }

        double X = Double.parseDouble(args[0]);
        double Y = Double.parseDouble(args[1]);
        double Z = Double.parseDouble(args[2]);
        float YAW = Float.parseFloat(args[3]);
        float PITCH = Float.parseFloat(args[4]);
        World WORLD = Bukkit.getWorld(args[5]);

        return new Location(WORLD, X, Y, Z, YAW, PITCH);
    }

    public static List<String> serializeList(List<Location> input) {
        return new ListConverter<Location, String>().convert(input, LocationAPI::serialize);
    }

    public static List<Location> deserializeList(List<String> input) {
        return new ListConverter<String, Location>().convert(input, LocationAPI::deserialize);
    }
}
