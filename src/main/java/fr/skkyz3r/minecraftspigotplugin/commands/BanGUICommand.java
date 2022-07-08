package fr.skkyz3r.minecraftspigotplugin.commands;

import fr.skkyz3r.minecraftspigotplugin.utils.BanMenuUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanGUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;

            BanMenuUtils.openBanMenu(p);

        }

        return true;
    }
}