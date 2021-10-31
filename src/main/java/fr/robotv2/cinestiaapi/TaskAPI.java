package fr.robotv2.cinestiaapi;

import org.bukkit.scheduler.BukkitTask;

public class TaskAPI {

    public static BukkitTask runTaskLater(Runnable task, Long timer) {
        return RobotAPI.getInstance().getServer().getScheduler().runTaskLater(RobotAPI.INSTANCE, task, timer);
    }

    public static BukkitTask runTaskLaterAsync(Runnable task, Long timer) {
        return RobotAPI.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(RobotAPI.INSTANCE, task, timer);
    }

    public static BukkitTask runTask(Runnable task) {
        return RobotAPI.getInstance().getServer().getScheduler().runTask(RobotAPI.INSTANCE, task);
    }

    public static BukkitTask runAsync(Runnable task) {
        return RobotAPI.getInstance().getServer().getScheduler().runTaskAsynchronously(RobotAPI.INSTANCE, task);
    }

    public static BukkitTask runTaskTimer(Runnable task, Long delay, Long timer) {
        return RobotAPI.getInstance().getServer().getScheduler().runTaskTimer(RobotAPI.INSTANCE, task, delay, timer);
    }

    public static BukkitTask runTaskTimerAsync(Runnable task, Long delay, Long timer) {
        return RobotAPI.getInstance().getServer().getScheduler().runTaskTimerAsynchronously(RobotAPI.INSTANCE, task, delay, timer);
    }
}
