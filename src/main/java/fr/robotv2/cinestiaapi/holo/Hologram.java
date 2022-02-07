package fr.robotv2.cinestiaapi.holo;

import com.google.common.collect.Iterables;
import fr.robotv2.cinestiaapi.color.ColorAPI;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.LinkedList;
import java.util.List;

public class Hologram {

    private String name;
    private boolean created = false;
    private boolean saved = false;
    private Location location;

    private final List<ArmorStand> entities = new LinkedList<>();
    private final List<String> lines;

    private final double DISTANCE_BETWEEN_STANDS = 0.2;

    public Hologram(Location location, String... lines) {
        this.location = location;
        this.lines = new LinkedList<>(List.of(lines));
    }

    public void setLocation(Location location) {
        this.location = location;
        delete();
        create();
    }

    public Location getLocation() {
        return location;
    }

    public List<String> getLines() {
        return ColorAPI.colorize(lines);
    }

    public List<ArmorStand> getEntities() {
        return entities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void create() {
        if(created) return;
        double count = 0;
        for(String line : getLines()) {
            Location current = getLocation().clone().add(0, count, 0);
            spawnArmorStand(line, current);
            count -= DISTANCE_BETWEEN_STANDS;
        }
        created = true;
    }

    public void delete() {
        getEntities().stream().filter(Entity::isValid).forEach(Entity::remove);
        created = false;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public void addLine(String line) {
        Entity entity = getLast(getEntities());
        Location current = entity.getLocation();
        current = current.clone().add(0, DISTANCE_BETWEEN_STANDS, 0);
        spawnArmorStand(line, current);
        getLines().add(ColorAPI.colorize(line));
    }

    public void removeLastLine() {
        Entity entity = getLast(getEntities());
        getEntities().remove(entity);
        if(entity.isValid()) entity.remove();
        getLines().remove(getLines().size() - 1);
        if(getEntities().isEmpty()) delete();
    }

    public void setLine(int index, String line) {
        index -= index;
        Entity entity = entities.get(index);
        getLines().set(index, ColorAPI.colorize(line));
        actualize();
    }

    public void actualize() {
        int count = 0;
        for(Entity entity : getEntities()) {
            String line = lines.get(count);
            entity.setCustomName(line);
            count++;
        }
    }

    private  <T> T getLast(List<T> list) {
        return Iterables.getLast(list);
    }

    private void spawnArmorStand(String line, Location location) {
        ArmorStand stand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        stand.setVisible(false);
        stand.setGravity(false);
        stand.setCustomName(line);
        stand.setCustomNameVisible(true);
        stand.setPersistent(true);
        entities.add(stand);
    }
}
