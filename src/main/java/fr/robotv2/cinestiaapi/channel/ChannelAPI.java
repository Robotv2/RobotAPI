package fr.robotv2.cinestiaapi.channel;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import fr.robotv2.cinestiaapi.RobotAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ChannelAPI {

    private static final List<String> channels = new ArrayList<>();
    public static List<String> getChannels() {
        return channels;
    }

    private static Player getLast() {
        try {
            return Iterables.getLast(Bukkit.getOnlinePlayers());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static void register(String channel) {
        if(channels.contains(channel)) return;
        RobotAPI.get().getServer().getMessenger().registerIncomingPluginChannel(RobotAPI.get(), channel, new ChannelListeners());
        RobotAPI.get().getServer().getMessenger().registerOutgoingPluginChannel(RobotAPI.get(), channel);
        channels.add(channel);
    }

    public static void unregister(String channel) {
        if(!channels.contains(channel)) return;
        channels.remove(channel);
        RobotAPI.get().getServer().getMessenger().unregisterIncomingPluginChannel(RobotAPI.get(), channel, new ChannelListeners());
        RobotAPI.get().getServer().getMessenger().registerOutgoingPluginChannel(RobotAPI.get(), channel);
    }

    public static void sendMessage(String channel, ByteArrayDataOutput out) {
        if(getLast() != null) {
            getLast().sendPluginMessage(RobotAPI.get(), channel, out.toByteArray());
        }
    }
}
