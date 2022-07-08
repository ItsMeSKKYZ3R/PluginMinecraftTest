package fr.skkyz3r.minecraftspigotplugin.commands;

import fr.skkyz3r.minecraftspigotplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.skkyz3r.minecraftspigotplugin.Main;

public class FlyCommand implements CommandExecutor {
    private boolean canFly;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("plugin-1.19.fly")) {
                if (canFly) {
                    this.canFly = false;
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.RED + "You can no longer fly.");
                } else {
                    this.canFly = true;
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.AQUA + "You can now fly. Be free!!!");
                }
            }
        }

        return true;
    }
}
