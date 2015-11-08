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
public class Hunter {

    public static void giveItems(Player player) {

        player.getInventory().clear();

        // SWORD

        ItemStack sword = new ItemStack(Material.STONE_SWORD);
        ItemMeta swordmeta = sword.getItemMeta();
        swordmeta.addEnchant(Enchantment.DURABILITY, 1, true);
        swordmeta.setDisplayName(String.format("%sHunter Sword", ChatColor.GREEN));
        sword.setItemMeta(swordmeta);
        player.getPlayer().getInventory().setItem(0, sword);

        // HELMET

        ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
        ItemMeta helmetmeta = helmet.getItemMeta();
        helmetmeta.setDisplayName(String.format("%sHunter Helmet", ChatColor.GREEN));
        helmet.setItemMeta(helmetmeta);
        player.getEquipment().setHelmet(helmet);

        // CHESTPLATE

        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplatemeta = chestplate.getItemMeta();
        chestplatemeta.setDisplayName(String.format("%sHunter Chestplate", ChatColor.GREEN));
        chestplate.setItemMeta(chestplatemeta);
        player.getEquipment().setChestplate(chestplate);

        // BOOTS

        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.setDisplayName(String.format("%sHunter Boots", ChatColor.GREEN));
        boots.setItemMeta(bootsmeta);
        player.getEquipment().setBoots(boots);

        // BOW
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowmeta = bow.getItemMeta();
        bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowmeta.setDisplayName(String.format("%sHunter Bow", ChatColor.GREEN));
        bow.setItemMeta(bowmeta);
        player.getPlayer().getInventory().setItem(1, bow);

        // ARROW
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta arrowmeta = arrow.getItemMeta();
        arrow.setItemMeta(arrowmeta);
        player.getPlayer().getInventory().setItem(27, arrow);

        // ROD
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        fishingrodmeta.setDisplayName(String.format("%sHunter Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(2, fishingrod);

    }

}
