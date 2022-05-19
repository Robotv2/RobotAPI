package fr.robotv2.robotapi.cooldown;

public class Cooldown {

    private final String name;
    private Long instant;
    private Integer seconds;

    public Cooldown(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCooldown(int seconds) {
        this.instant = System.currentTimeMillis();
        this.seconds = seconds;
    }

    public Long getRemainingCooldown() {
        if(instant == null) return 0L;
        return ((System.currentTimeMillis() - instant) / 1000);
    }

    public boolean isCooldownOver() {
        if(instant == null) return true;
        if(seconds == null) return true;
        return ((System.currentTimeMillis() - instant) / 1000) > seconds;
    }

    public void clearCooldown() {
        this.instant = null;
        this.seconds = null;
    }
}
