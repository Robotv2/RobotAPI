package fr.robotv2.cinestiaapi.command;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

import static fr.robotv2.cinestiaapi.color.ColorAPI.colorize;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {

    private final JavaPlugin plugin;
    protected String name;
    protected Set<String> subsName;
    protected Map<String, AbstractSub> subs = new HashMap<>();

    public AbstractCommand(JavaPlugin plugin, String name) {
        this.plugin = plugin;
        this.name = name;
        @Nullable PluginCommand command = plugin.getCommand(name);
        if (command != null) {
            command.setExecutor(this);
            command.setTabCompleter(this);
            this.subsName = getSubs().stream().map(AbstractSub::getName).collect(Collectors.toSet());
            for(AbstractSub sub : getSubs()) {
                subs.put(sub.getName().toLowerCase(), sub);
            }
        } else
            throw new CommandException(colorize("Vous n'avez pas enregistrer la commande " +  name + " dans le plugin.yml."));
    }

    public void execute(CommandSender sender, String[] args) {}
    public void execute(Player player, String[] args) {};

    public String getPermission() {
        return Objects.requireNonNull(plugin.getCommand(name)).getPermission();
    }

    public String getUsage() {
        return Objects.requireNonNull(plugin.getCommand(name)).getUsage();
    }

    public abstract Set<AbstractSub> getSubs();
    public abstract boolean enableTabCompleter();

    private boolean hasPermission(CommandSender sender) {
        return (getPermission() == null || sender.hasPermission(getPermission()));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {

        if(args.length == 0) {
            if(sender instanceof Player player) {
                this.execute(player, args);
            } else {
                this.execute(sender, args);
            }
            return true;
        }

        if(args.length == 1 && subs.containsKey(args[0].toLowerCase())) {
            AbstractSub sub = subs.get(args[0].toLowerCase());
            sub.execute(sender, args);
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(enableTabCompleter() && hasPermission(sender)) {
            if (args[0].length() == 0)
                return new ArrayList<>(subsName);
            if (args.length == 1)
                return subsName.stream().filter(arg -> arg.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
        }
        return null;
    }
}