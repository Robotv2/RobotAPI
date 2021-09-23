package fr.robotv2.cinestiaapi.command.stock;

import fr.robotv2.cinestiaapi.ItemAPI;
import fr.robotv2.cinestiaapi.OfflineAPI;
import fr.robotv2.cinestiaapi.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static fr.robotv2.cinestiaapi.ItemAPI.getCachedHeads;

public class apiCommand extends Command {
    public apiCommand(JavaPlugin plugin, String name) {
        super(plugin, name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) return;
        String url = args[0];

        player.getInventory().addItem(
                ItemAPI.getHead(url)
        );
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public String getPermissionMessage() {
        return null;
    }

    @Override
    public boolean canConsoleExecute() {
        return false;
    }

    @Override
    public String getNotConsoleMessage() {
        return "Tu ne peux pas faire ça";
    }

    @Override
    public List<String> getSubsCommands() {
        List<String> result = new ArrayList<>();
        getCachedHeads().forEach((key, value) -> result.add(OfflineAPI.getName(UUID.fromString(key))));
        return result;
    }

    @Override
    public boolean enableTabCompleter() {
        return true;
    }
}
