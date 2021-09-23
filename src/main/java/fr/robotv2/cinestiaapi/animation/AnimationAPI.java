package fr.robotv2.cinestiaapi.animation;

import fr.robotv2.cinestiaapi.animation.effects.ExpandingCircleEffect;
import fr.robotv2.cinestiaapi.robotAPI;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class AnimationAPI {

    public static HashMap<Player, BukkitTask> animations = new HashMap<>();

    public static BukkitTask getCurrent(Player player) {
        return animations.get(player);
    }

    public static void stopCurrent(Player player) {
        if(getCurrent(player) != null)
            getCurrent(player).cancel();
    }

    public static void playHelix(Player player) {
        Location loc = player.getLocation();
        int radius = 2;
        for(double y = 0; y <= 50; y+=0.05) {
            double x = radius * Math.cos(y);
            double z = radius * Math.sin(y);
            player.spawnParticle(Particle.FLAME, (loc.getX() + x), (loc.getY() + y), (loc.getZ() + z), 1);
        }}

    public static void playExpandingEffectCircle(Player player, Long speed, Particle particle) {
        stopCurrent(player);
        BukkitTask task = new ExpandingCircleEffect(player, player.getLocation(), 1, 8, 0.5, particle).runTaskTimer(robotAPI.INSTANCE, 0, speed);
        animations.put(player, task);
    }
}
