package fr.robotv2.robotapi.animation.effects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AshCone extends BukkitRunnable {

    private final Player player;
    private final Particle particle;
    private double phi = 0;

    public AshCone(Player player, Particle particle) {
        this.player = player;
        this.particle = particle;
    }

    @Override
    public void run() {
        phi += Math.PI/16;
        double x; double y; double z;
        Location loc = player.getLocation();
        for (double t = 0; t <= 2 * Math.PI; t += Math.PI/16) {
            for (double i = 0; i <= 1; i += 1){
                x = 0.15*(2*Math.PI-t) * Math.cos(t + phi + i*Math.PI);
                y = 0.5*t;
                z = 0.15*(2*Math.PI-t) * Math.sin(t + phi + i*Math.PI);
                loc.add(x,y,z);
                player.spawnParticle(particle, loc, 0, 0, 0, 0, 1);
                loc.subtract(x,y,z);
            }
        }
        if (phi > 10*Math.PI) {
            this.cancel();
        }
    }
}
