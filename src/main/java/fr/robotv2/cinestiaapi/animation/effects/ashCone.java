package fr.robotv2.cinestiaapi.animation.effects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ashCone extends BukkitRunnable {

    private final Player player;
    private double phi = 0;

    public ashCone(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        phi += Math.PI/16;
        double x; double y; double z;
        Location loc = player.getLocation();
        World world = player.getWorld();
        for (double t = 0; t <= 2 * Math.PI; t += Math.PI/16) {
            for (double i = 0; i <= 1; i += 1){
                x = 0.15*(2*Math.PI-t) * Math.cos(t + phi + i*Math.PI);
                y = 0.5*t;
                z = 0.15*(2*Math.PI-t) * Math.sin(t + phi + i*Math.PI);
                loc.add(x,y,z);
                player.spawnParticle(Particle.ASH, loc, 0, 0, 0, 0, 1);
                loc.subtract(x,y,z);
            }
        }
        if (phi > 10*Math.PI) {
            this.cancel();
        }
    }
}
