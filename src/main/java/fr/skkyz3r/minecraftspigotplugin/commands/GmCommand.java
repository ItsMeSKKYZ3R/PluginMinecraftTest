package fr.skkyz3r.minecraftspigotplugin.commands;

import fr.skkyz3r.minecraftspigotplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                Player player = (Player) sender;

                if (args[0].equalsIgnoreCase("0")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("Vous êtes maintenant en mode survie");
                } else if (args[0].equalsIgnoreCase("1")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("Vous êtes maintenant en mode créatif");
                } else if (args[0].equalsIgnoreCase("2")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("Vous êtes maintenant en mode aventure");
                } else if (args[0].equalsIgnoreCase("3")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("Vous êtes maintenant en mode spectateur");
                }
            } else if (args.length == 2) {
                Player target = Bukkit.getPlayerExact(args[1]);

                if (args[0].equalsIgnoreCase("0")) {
                    target.setGameMode(GameMode.SURVIVAL);
                    target.sendMessage("Vous êtes maintenant en mode survie");
                } else if (args[0].equalsIgnoreCase("1")) {
                    target.setGameMode(GameMode.CREATIVE);
                    target.sendMessage("Vous êtes maintenant en mode créatif");
                } else if (args[0].equalsIgnoreCase("2")) {
                    target.setGameMode(GameMode.ADVENTURE);
                    target.sendMessage("Vous êtes maintenant en mode aventure");
                } else if (args[0].equalsIgnoreCase("3")) {
                    target.setGameMode(GameMode.SPECTATOR);
                    target.sendMessage("Vous êtes maintenant en mode spectateur");
                }
            } else {
                Player player = (Player) sender;

                player.sendMessage("You need to give the command an argument.");
                player.sendMessage("/gm <0|1|2|3> [user]");
            }
        } else {
            Main.getPlugin().getLogger().info("You have to be a player to get help.");
        }

        return false;
    }
}