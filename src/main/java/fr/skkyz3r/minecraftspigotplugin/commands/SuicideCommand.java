package fr.skkyz3r.minecraftspigotplugin.commands;

import fr.skkyz3r.minecraftspigotplugin.Main;
import fr.skkyz3r.minecraftspigotplugin.systems.menu.menus.SuicideConfirmMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuicideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            SuicideConfirmMenu suicideConfirmMenu = new SuicideConfirmMenu(Main.getPlayerMenuUtility(player));

            suicideConfirmMenu.open();
        }

        return true;
    }
}
