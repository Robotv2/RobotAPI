package fr.robotv2.cinestiaapi;

import org.bukkit.scheduler.BukkitTask;

public class TaskAPI {

    public static BukkitTask runTaskLater(Runnable task, Long timer) {
        return robotAPI.INSTANCE.getServer().getScheduler().runTaskLater(robotAPI.INSTANCE, task, timer);
    }

    public static BukkitTask runTaskLaterAsync(Runnable task, Long timer) {
        return robotAPI.INSTANCE.getServer().getScheduler().runTaskLaterAsynchronously(robotAPI.INSTANCE, task, timer);
    }

    public static BukkitTask runTask(Runnable task) {
        return robotAPI.INSTANCE.getServer().getScheduler().runTask(robotAPI.INSTANCE, task);
    }

    public static BukkitTask runAsync(Runnable task) {
        return robotAPI.INSTANCE.getServer().getScheduler().runTaskAsynchronously(robotAPI.INSTANCE, task);
    }

    public static BukkitTask runTaskTimer(Runnable task, Long delay, Long timer) {
        return robotAPI.INSTANCE.getServer().getScheduler().runTaskTimer(robotAPI.INSTANCE, task, delay, timer);
    }

    public static BukkitTask runTaskTimerAsync(Runnable task, Long delay, Long timer) {
        return robotAPI.INSTANCE.getServer().getScheduler().runTaskTimerAsynchronously(robotAPI.INSTANCE, task, delay, timer);
    }
}
