package com.lttf.UltimatumKit.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by user on 7/11/2015.
 */
public class Tim {
    public static void giveItems(Player player) {

        player.getInventory().clear();

        // IRON SWORD

        ItemStack timsword = new ItemStack(Material.STONE_SWORD);
        ItemMeta timswordmeta = timsword.getItemMeta();
        timswordmeta.setDisplayName(String.format("%sTim Sword", ChatColor.GREEN));
        timsword.setItemMeta(timswordmeta);
        player.getPlayer().getInventory().setItem(0, timsword);

        // GOLD HELMET

        ItemStack timhelmet = new ItemStack(Material.GOLD_HELMET);
        ItemMeta timhelmetmeta = timhelmet.getItemMeta();
        timhelmetmeta.setDisplayName(String.format("%sTim Helmet", ChatColor.GREEN));
        timhelmet.setItemMeta(timhelmetmeta);
        player.getEquipment().setHelmet(timhelmet);

        // GOLD CHESTPLATE

        ItemStack timchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta timchestplatemeta = timchestplate.getItemMeta();
        timchestplatemeta.setDisplayName(String.format("%sTim Chestplate", ChatColor.GREEN));
        timchestplate.setItemMeta(timchestplatemeta);
        player.getEquipment().setChestplate(timchestplate);

        // GOLD LEGGINGS

        ItemStack timleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta timleggingsmeta = timleggings.getItemMeta();
        timleggingsmeta.setDisplayName(String.format("%sTim Leggings", ChatColor.GREEN));
        timleggings.setItemMeta(timleggingsmeta);
        player.getEquipment().setLeggings(timleggings);

        // GOLD BOOTS

        ItemStack timboots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta timbootsmeta = timboots.getItemMeta();
        timbootsmeta.setDisplayName(String.format("%sTim Boots", ChatColor.GREEN));
        timboots.setItemMeta(timbootsmeta);
        player.getEquipment().setBoots(timboots);

        // EXPERIENCE BOTTLE

        ItemStack experiencebottle = new ItemStack(Material.EXP_BOTTLE, 12);
        player.getPlayer().getInventory().setItem(2, experiencebottle);

        // FISHING ROD

        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        fishingrodmeta.setDisplayName(String.format("%sTim Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(1, fishingrod);
    }
}
