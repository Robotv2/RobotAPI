package fr.robotv2.cinestiaapi.holo;

import org.bukkit.Location;

import java.util.*;

public class HologramAPI {

    private static final Map<String, Hologram> holograms = new HashMap<>();

    public static Hologram createHologram(Location location, String... lines) {
        return createHologramWithName(location, null, lines);
    }

    public static Hologram createHologramWithName(Location location, String name, String... lines) {
        Hologram hologram = new Hologram(location, lines);
        if(!Objects.isNull(name)) hologram.setName(name);
        else hologram.setName(UUID.randomUUID().toString());
        holograms.put(name, hologram);
        hologram.create();
        return hologram;
    }

    public static Hologram getHologram(String name) {
        return holograms.get(name);
    }

    public static Collection<Hologram> getHolograms() {
        return holograms.values();
    }
}
