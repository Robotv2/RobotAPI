package fr.robotv2.robotapi;

import org.bukkit.scheduler.BukkitTask;

public class TaskAPI {

    public static BukkitTask runTaskLater(Runnable task, Long timer) {
        return RobotAPI.get().getServer().getScheduler().runTaskLater(RobotAPI.get(), task, timer);
    }

    public static BukkitTask runTaskLaterAsync(Runnable task, Long timer) {
        return RobotAPI.get().getServer().getScheduler().runTaskLaterAsynchronously(RobotAPI.get(), task, timer);
    }

    public static BukkitTask runTask(Runnable task) {
        return RobotAPI.get().getServer().getScheduler().runTask(RobotAPI.get(), task);
    }

    public static BukkitTask runAsync(Runnable task) {
        return RobotAPI.get().getServer().getScheduler().runTaskAsynchronously(RobotAPI.get(), task);
    }

    public static BukkitTask runTaskTimer(Runnable task, Long delay, Long timer) {
        return RobotAPI.get().getServer().getScheduler().runTaskTimer(RobotAPI.get(), task, delay, timer);
    }

    public static BukkitTask runTaskTimerAsync(Runnable task, Long delay, Long timer) {
        return RobotAPI.get().getServer().getScheduler().runTaskTimerAsynchronously(RobotAPI.get(), task, delay, timer);
    }
}
