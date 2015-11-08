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
public class RedDragon {

    public static void giveItems(Player player) {

        player.getInventory().clear();

        // IRON SWORD

        ItemStack sword = new ItemStack(Material.STONE_SWORD);
        ItemMeta swordmeta = sword.getItemMeta();
        swordmeta.setDisplayName(String.format("%sRed Dragon Sword", ChatColor.GREEN));
        sword.setItemMeta(swordmeta);
        player.getPlayer().getInventory().setItem(0, sword);

        // GOLD HELMET

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta helmetmeta = helmet.getItemMeta();
        helmetmeta.addEnchant(Enchantment.PROTECTION_FIRE, 2, true);
        helmetmeta.setDisplayName(String.format("%sRed Dragon Helmet", ChatColor.GREEN));
        helmet.setItemMeta(helmetmeta);
        player.getEquipment().setHelmet(helmet);

        // GOLD CHESTPLATE

        ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplatemeta = chestplate.getItemMeta();
        chestplatemeta.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
        chestplatemeta.setDisplayName(String.format("%sRed Dragon Chestplate", ChatColor.GREEN));
        chestplate.setItemMeta(chestplatemeta);
        player.getEquipment().setChestplate(chestplate);

        // GOLD LEGGINGS

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta leggingsmeta = leggings.getItemMeta();
        leggingsmeta.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);
        leggingsmeta.setDisplayName(String.format("%sRed Dragon Leggings", ChatColor.GREEN));
        leggings.setItemMeta(leggingsmeta);
        player.getEquipment().setLeggings(leggings);

        // GOLD BOOTS

        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta bootsmeta = boots.getItemMeta();
        bootsmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 2, true);
        bootsmeta.setDisplayName(String.format("%sRed Dragon Boots", ChatColor.GREEN));
        boots.setItemMeta(bootsmeta);
        player.getEquipment().setBoots(boots);

        // FISHING ROD
        ItemStack fishingrod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingrodmeta = fishingrod.getItemMeta();
        fishingrodmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        fishingrodmeta.setDisplayName(String.format("%sRed Dragon Fishing Rod", ChatColor.GREEN));
        fishingrod.setItemMeta(fishingrodmeta);
        player.getPlayer().getInventory().setItem(1, fishingrod);
    }

}
