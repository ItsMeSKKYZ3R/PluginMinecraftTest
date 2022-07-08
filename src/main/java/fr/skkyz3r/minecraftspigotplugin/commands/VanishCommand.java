package fr.skkyz3r.minecraftspigotplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import fr.skkyz3r.minecraftspigotplugin.Main;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<Player> invisible_list = new ArrayList<>();

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (invisible_list.contains(player)) {
                invisible_list.remove(player);
                player.sendMessage("You are now visible to other players on the server.");
            } else if (!invisible_list.contains(player)) {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.hidePlayer(Main.getPlugin(), player);
                }

                invisible_list.add(player);
                player.sendMessage("You are now invisible!");
            }
        }

        return true;
    }
}
