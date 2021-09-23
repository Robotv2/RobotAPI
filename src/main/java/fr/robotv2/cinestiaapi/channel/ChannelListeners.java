package fr.robotv2.cinestiaapi.channel;

import com.google.common.io.ByteStreams;
import fr.robotv2.cinestiaapi.robotAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

public class ChannelListeners implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte[] message) {
        if(ChannelAPI.getChannels().contains(channel)) {
            robotAPI.INSTANCE.getServer().getPluginManager()
                    .callEvent(new ChannelMessageEvent(channel, player, ByteStreams.newDataInput(message)));
        }
    }
}
