package fr.skkyz3r.minecraftspigotplugin.tabcompletions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GmTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> gameMode = new ArrayList<>();

            gameMode.add("0");
            gameMode.add("1");
            gameMode.add("2");
            gameMode.add("3");

            return gameMode;
        }

        return null;
    }
}
