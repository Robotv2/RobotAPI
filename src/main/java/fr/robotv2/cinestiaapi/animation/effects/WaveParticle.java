package fr.robotv2.cinestiaapi.animation.effects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class WaveParticle extends BukkitRunnable {

    private final Player player;
    private final Location loc;
    double t = Math.PI / 4;

    public WaveParticle(Player player) {
        this.player = player;
        this.loc = player.getLocation();
    }

    @Override
    public void run() {
        t = t + 0.1 * Math.PI;
        for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
            double x = t * Math.cos(theta);
            double y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 1.5;
            double z = t * Math.sin(theta);
            loc.add(x, y, z);
            player.spawnParticle(Particle.FIREWORKS_SPARK, loc, 1, 0, 0, 0, 0);
            loc.subtract(x, y, z);

            theta = theta + Math.PI / 64;

            x = t * Math.cos(theta);
            y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 1.5;
            z = t * Math.sin(theta);
            loc.add(x, y, z);
            player.spawnParticle(Particle.SPELL_WITCH, loc, 1, 0, 0, 0);
            loc.subtract(x, y, z);
        }
        if (t > 20) {
            this.cancel();
        }
    }
}
