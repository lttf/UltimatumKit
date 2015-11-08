package com.lttf.UltimatumKit.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by user on 6/11/2015.
 */
public class Knight {

    public static void giveItems(Player player) {

        player.getInventory().clear();

        // IRON SWORD

        ItemStack knightsword = new ItemStack(Material.IRON_SWORD);
        ItemMeta knightswordmeta = knightsword.getItemMeta();
        knightswordmeta.setDisplayName(String.format("%sKnight Sword", ChatColor.GREEN));
        knightsword.setItemMeta(knightswordmeta);
        player.getPlayer().getInventory().setItem(0, knightsword);

        // GOLD HELMET

        ItemStack knighthelmet = new ItemStack(Material.GOLD_HELMET);
        ItemMeta knighthelmetmeta = knighthelmet.getItemMeta();
        knighthelmetmeta.setDisplayName(String.format("%sKnight Helmet", ChatColor.GREEN));
        knighthelmet.setItemMeta(knighthelmetmeta);
        player.getEquipment().setHelmet(knighthelmet);

        // GOLD CHESTPLATE

        ItemStack knightchestplate = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta knightchestplatemeta = knightchestplate.getItemMeta();
        knightchestplatemeta.setDisplayName(String.format("%sKnight Chestplate", ChatColor.GREEN));
        knightchestplate.setItemMeta(knightchestplatemeta);
        player.getEquipment().setChestplate(knightchestplate);

        // GOLD LEGGINGS

        ItemStack knightleggings = new ItemStack(Material.GOLD_LEGGINGS);
        ItemMeta knightleggingsmeta = knightleggings.getItemMeta();
        knightleggingsmeta.setDisplayName(String.format("%sKnight Leggings", ChatColor.GREEN));
        knightleggings.setItemMeta(knightleggingsmeta);
        player.getEquipment().setLeggings(knightleggings);

        // GOLD BOOTS

        ItemStack knightboots = new ItemStack(Material.GOLD_BOOTS);
        ItemMeta knightbootsmeta = knightboots.getItemMeta();
        knightbootsmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        knightbootsmeta.setDisplayName(String.format("%sKnight Boots", ChatColor.GREEN));
        knightboots.setItemMeta(knightbootsmeta);
        player.getEquipment().setBoots(knightboots);

        // GOLDEN CARROTS
        ItemStack goldencarrots = new ItemStack(Material.GOLDEN_CARROT, 2);
        player.getPlayer().getInventory().setItem(2, goldencarrots);

        // FISHING ROD
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        fishingrodmeta.setDisplayName(String.format("%sKnight Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(1, fishingrod);
    }

}
