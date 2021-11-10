package fr.robotv2.cinestiaapi.animation.effects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ExpandingCircleEffect extends BukkitRunnable {

    private final Player player;
    private final Location loc;
    private double startRadius;
    private final double endRadius;
    private final double radiusIncrease;
    private final Particle particle;

    private void playCircleEffect(Player player, Location loc, double radius) {
        for (double angle = 0; angle < 2 * Math.PI; angle += Math.PI / 36) {
            final double x = radius * Math.cos(angle);
            final double z = radius * Math.sin(angle);
            loc.add(x, 0, z);
            player.getWorld().spawnParticle(particle, loc.getX(), loc.getY(), loc.getZ(), 1);
            loc.subtract(x, 0, z);
        }
    }

    public ExpandingCircleEffect(Player player, Location loc, double startRadius, double endRadius, double radiusIncrease, Particle particle) {
        this.player = player;
        this.loc = loc;
        this.startRadius = startRadius;
        this.endRadius = endRadius;
        this.radiusIncrease = radiusIncrease;
        this.particle = particle;
    }

    @Override
    public void run() {
        playCircleEffect(player, loc, startRadius);
        startRadius += radiusIncrease;
        if (startRadius >= endRadius) {
            this.cancel();
        }
    }
}
