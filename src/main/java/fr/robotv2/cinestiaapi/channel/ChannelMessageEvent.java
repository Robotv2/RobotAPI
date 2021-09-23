package fr.robotv2.cinestiaapi.channel;

import com.google.common.io.ByteArrayDataInput;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChannelMessageEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final String channel;
    private final Player player;
    private final ByteArrayDataInput input;

    public ChannelMessageEvent(String channel, Player player, ByteArrayDataInput input) {
        this.channel = channel;
        this.player = player;
        this.input = input;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public String getChannel() {
        return channel;
    }

    public Player getPlayer() {
        return player;
    }

    public ByteArrayDataInput getInput() {
        return input;
    }
}
