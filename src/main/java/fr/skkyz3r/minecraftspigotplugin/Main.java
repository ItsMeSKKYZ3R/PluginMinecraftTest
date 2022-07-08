package fr.skkyz3r.minecraftspigotplugin;

import fr.skkyz3r.minecraftspigotplugin.commands.*;
import fr.skkyz3r.minecraftspigotplugin.listeners.BanInventoryListener;
import fr.skkyz3r.minecraftspigotplugin.listeners.MenuListener;
import fr.skkyz3r.minecraftspigotplugin.systems.menu.PlayerMenuUtility;
import fr.skkyz3r.minecraftspigotplugin.tabcompletions.GmTabCompletion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Objects;

public final class Main extends JavaPlugin {
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Gamemode command
        Objects.requireNonNull(getCommand("gm")).setExecutor(new GmCommand());
        Objects.requireNonNull(getCommand("gm")).setTabCompleter(new GmTabCompletion());

        // Fly command
        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());

        // Vanish command
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new VanishCommand());

        // Suicide command
        Objects.requireNonNull(getCommand("suicide")).setExecutor(new SuicideCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        // Bangui command
        Objects.requireNonNull(getCommand("bangui")).setExecutor(new BanGUICommand());
        getServer().getPluginManager().registerEvents(new BanInventoryListener(), this);
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;

        if (playerMenuUtilityMap.containsKey(player)) {
            return playerMenuUtilityMap.get(player);
        } else {
            playerMenuUtility = new PlayerMenuUtility(player);

            playerMenuUtilityMap.put(player, playerMenuUtility);

            return playerMenuUtility;
        }
    }

    public static Main getPlugin() {
        return plugin;
    }
}