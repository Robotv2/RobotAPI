package fr.robotv2.cinestiaapi.animation.effects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;

public class FireSpiral extends BukkitRunnable {

    private Player player;
    private Location loc;
    private double t = 0;
    private double r = 1;

    public FireSpiral(Player player) {
        this.player = player;
        this.loc = player.getLocation();
    }

    @Override
    public void run() {
        t = t + Math.PI/8;
        double x = r * Math.cos(t);
        double y = t;
        double z = r * Math.sin(t);
        loc.add(x, y, z);
        player.spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
        loc.subtract(x, y, z);
        if (t > Math.PI*4){
            this.cancel();
        }
    }
}
