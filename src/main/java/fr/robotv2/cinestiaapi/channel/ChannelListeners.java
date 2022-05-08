package fr.robotv2.cinestiaapi.channel;

import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

public class ChannelListeners implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte[] message) {
        if(ChannelAPI.getChannels().contains(channel)) {
            Bukkit.getPluginManager()
                    .callEvent(new ChannelMessageEvent(channel, player, ByteStreams.newDataInput(message)));
        }
    }
}
