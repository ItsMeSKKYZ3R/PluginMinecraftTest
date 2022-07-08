package fr.skkyz3r.minecraftspigotplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

public class BanMenuUtils {
    public static void openBanMenu(Player player) {
        ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

        Inventory bangui = Bukkit.createInventory(player, 54, ChatColor.BLUE + "Player List");

        for (int i = 0; i < list.size(); i++) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(list.get(i).getDisplayName());

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player health: " + list.get(i).getHealth());
            lore.add(ChatColor.GOLD + "EXP: " + ChatColor.AQUA + list.get(i).getExp());

            meta.setLore(lore);

            playerHead.setItemMeta(meta);

            bangui.addItem(playerHead);
        }

        player.openInventory(bangui);
    }

    public static void openPlayerMenu(Player player1, Player whoToBan){

        //Player to be banned
        Player banMe = whoToBan;

        //Open up ban menu
        Inventory banPlayerMenu = Bukkit.createInventory(player1, 9, "Ban This Noob");

        //Ban Option
        ItemStack ban = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(ChatColor.DARK_GREEN + "Ban");
        ban.setItemMeta(ban_meta);
        banPlayerMenu.setItem(0, ban);

        //Add player
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta player_meta = playerHead.getItemMeta();
        player_meta.setDisplayName(banMe.getDisplayName());
        playerHead.setItemMeta(player_meta);
        banPlayerMenu.setItem(4, playerHead);

        //Cancel option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.RED + "Go Back!");
        cancel.setItemMeta(cancel_meta);
        banPlayerMenu.setItem(8, cancel);

        player1.openInventory(banPlayerMenu);
    }
}
