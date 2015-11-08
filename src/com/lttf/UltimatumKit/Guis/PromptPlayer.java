package com.lttf.UltimatumKit.Guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/11/2015.
 */
public class PromptPlayer {

    public static void promptInventory(Player player) {
        Inventory areyousure = Bukkit.createInventory(null, 27, "Are you sure?");

        // Yes (Green Wool)
        ItemStack yes = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getData());
        ItemMeta yesmeta = yes.getItemMeta();
        yesmeta.setDisplayName(ChatColor.GREEN + "YES");
        List<String> yeslore = new ArrayList<String>();
        yeslore.add(ChatColor.GRAY + "By clicking here, you agree to purchase this item!");
        yesmeta.setLore(yeslore);
        yes.setItemMeta(yesmeta);

        // No (Barrier Symbol)
        ItemStack no = new ItemStack(Material.BARRIER);
        ItemMeta nometa = no.getItemMeta();
        nometa.setDisplayName(ChatColor.RED + "NO");
        List<String> nolore = new ArrayList<String>();
        nolore.add(ChatColor.GRAY + "By clicking here, you disagree about purchasing this item!");
        nometa.setLore(nolore);
        no.setItemMeta(nometa);

        areyousure.setItem(11, yes);
        areyousure.setItem(15, no);

        player.openInventory(areyousure);
    }
}
