package fr.robotv2.cinestiaapi.channel;

import fr.robotv2.cinestiaapi.robotAPI;

import java.util.ArrayList;
import java.util.List;

public class ChannelAPI {

    private static final List<String> channels = new ArrayList<>();
    public static List<String> getChannels() {
        return channels;
    }

    public static void register(String channel) {
        if(channels.contains(channel)) return;
        robotAPI.INSTANCE.getServer().getMessenger().registerIncomingPluginChannel(robotAPI.INSTANCE, channel, new ChannelListeners());
        robotAPI.INSTANCE.getServer().getMessenger().registerOutgoingPluginChannel(robotAPI.INSTANCE, channel);
        channels.add(channel);
    }

    public static void unregister(String channel) {
        if(!channels.contains(channel)) return;
        channels.remove(channel);
        robotAPI.INSTANCE.getServer().getMessenger().unregisterIncomingPluginChannel(robotAPI.INSTANCE, channel, new ChannelListeners());
        robotAPI.INSTANCE.getServer().getMessenger().registerOutgoingPluginChannel(robotAPI.INSTANCE, channel);
    }
}
