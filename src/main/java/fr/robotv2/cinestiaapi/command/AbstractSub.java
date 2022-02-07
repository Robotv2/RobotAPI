package fr.robotv2.cinestiaapi.command;

import org.bukkit.command.CommandSender;

public interface AbstractSub {

    String getName();
    void execute(CommandSender sender, String[] args);
}
